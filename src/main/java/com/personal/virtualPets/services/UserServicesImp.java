package com.personal.virtualPets.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.personal.virtualPets.dtos.PasswordDTO;
import com.personal.virtualPets.dtos.ProfileRequestDTO;
import com.personal.virtualPets.dtos.UserRequestDTO;
import com.personal.virtualPets.dtos.UserResponseDTO;
import com.personal.virtualPets.entities.UserEntity;
import com.personal.virtualPets.enums.UserRole;
import com.personal.virtualPets.repositories.UserRepository;

@Service
public class UserServicesImp implements UserServices {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private DTOServices dtoServ;
	@Autowired
	private ProfileServices profServ;

	// TODO Add Randomization for verification
	@Override
	public ResponseEntity<?> newUser(UserRequestDTO data, UserRole role) {
		if (data.getEmail().isEmpty() || data.getPassword().isEmpty() || data.getUsername().isEmpty())
			return new ResponseEntity<>("Data incomplete", HttpStatus.BAD_REQUEST);
		UserEntity user = new UserEntity();
		user.setEmail(data.getEmail());
		user.setPassword(data.getPassword());
		user.setUsername(data.getUsername());
		user.setRole(role);
		user.setVerification("TODOaddRandomizationMethodToThis");
		UserResponseDTO resp = dtoServ.userToDto(userRepo.save(user));
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getUserById(Integer id) {
		if (id == null)
			return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
		if (userRepo.existsById(id)) {
			UserEntity data = userRepo.findById(id).orElse(null);
			return new ResponseEntity<>(dtoServ.userToDto(data), HttpStatus.OK);
		}
		return new ResponseEntity<>("User not found", HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<?> getUserByUsername(String username) {
		if (username == null)
			return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
		if (userRepo.existsByUsername(username)) {
			UserEntity data = userRepo.findByUsername(username);
			return new ResponseEntity<>(dtoServ.userToDto(data), HttpStatus.OK);
		}
		return new ResponseEntity<>("User not found", HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<?> getAllAdmins() {
		List<UserEntity> data = userRepo.findAllByRole(UserRole.ROLE_ADMIN);
		if (data.isEmpty())
			return new ResponseEntity<>("No Admins Found", HttpStatus.NO_CONTENT);
		List<UserResponseDTO> resp = new ArrayList<>();
		for (UserEntity i : data) {
			resp.add(dtoServ.userToDto(i));
		}
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getAllUsers() {
		List<UserEntity> data = (List<UserEntity>) userRepo.findAll();
		if (data.isEmpty())
			return new ResponseEntity<>("No Users Found", HttpStatus.NO_CONTENT);
		List<UserResponseDTO> resp = new ArrayList<>();
		for (UserEntity i : data) {
			resp.add(dtoServ.userToDto(i));
		}
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	// TODO When deleting, also delete profile and abandon pets
	@Override
	public ResponseEntity<?> deleteUser(Integer id) {
		if (id == null)
			return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
		if (userRepo.existsById(id)) {
			profServ.deleteProfile(id);
			userRepo.deleteById(id);
			return new ResponseEntity<>("User deleted", HttpStatus.OK);
		}
		return new ResponseEntity<>("User not found", HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<?> editUser(Integer id, UserRequestDTO data) {
		if (id == null)
			return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
		if (userRepo.existsById(id)) {
			UserEntity user = userRepo.findById(id).orElse(null);
			if (!data.getPassword().isEmpty() && user.getPassword() == data.getPassword()) {
				if (!data.getUsername().isEmpty()) {
					if (userRepo.existsByUsername(data.getUsername())
							&& !user.equals(userRepo.findByUsername(data.getUsername())))
						return new ResponseEntity<>("Change not allowed", HttpStatus.BAD_REQUEST);
					user.setUsername(data.getUsername());
				}
				if (!data.getEmail().isEmpty()) {
					if (userRepo.existsByEmail(data.getEmail()) && !user.equals(userRepo.findByEmail(data.getEmail())))
						return new ResponseEntity<>("Change not allowed", HttpStatus.BAD_REQUEST);
					user.setEmail(data.getEmail());
				}
				UserResponseDTO resp = dtoServ.userToDto(userRepo.save(user));
				return new ResponseEntity<>(resp, HttpStatus.OK);
			} else
				return new ResponseEntity<>("Change not allowed", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("User not found", HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<?> verify(Integer id, String ver) {
		if (id == null || ver == null)
			return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
		if (userRepo.existsById(id)) {
			UserEntity user = userRepo.findById(id).orElse(null);
			if (ver.equals(user.getVerification()) && user.getRole().equals(UserRole.ROLE_VERIFY)) {
				user.setRole(UserRole.ROLE_USER);
				profServ.newProfile(id, new ProfileRequestDTO(user.getUsername()));
				UserResponseDTO resp = dtoServ.userToDto(userRepo.save(user));
				return new ResponseEntity<>(resp, HttpStatus.OK);
			}
			return new ResponseEntity<>("Verification failed", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("User not found", HttpStatus.NO_CONTENT);
	}

	// TODO more secure password handling
	@Override
	public ResponseEntity<?> changePass(Integer id, PasswordDTO pass) {
		if (pass.getOldPass() == null || pass.getNewPass() == null || pass.getVerPass() == null)
			return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
		if (userRepo.existsById(id)) {
			UserEntity user = userRepo.findById(id).orElse(null);
			if (user.getPassword().equals(pass.getOldPass()) && pass.getNewPass().equals(pass.getVerPass())) {
				user.setPassword(pass.getNewPass());
				UserResponseDTO resp = dtoServ.userToDto(userRepo.save(user));
				return new ResponseEntity<>(resp, HttpStatus.OK);
			}
			return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("User not found", HttpStatus.NO_CONTENT);
	}

}
