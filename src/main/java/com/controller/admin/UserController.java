package com.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.UserEntity;
import com.repository.UserRepository;

@RestController
@RequestMapping("/admin")
public class UserController {

	// get all users from database

	@Autowired
	UserRepository userRepository;

	@GetMapping("users")
	public List<UserEntity> getAllUsers() {
		List<UserEntity> users = userRepository.findAll();
		return users;
	}

	@DeleteMapping("/user/{userId}")
	public String removeUserById(@PathVariable("userId") Integer userId) {
		userRepository.deleteById(userId);
		return "success";
	}

	@PutMapping("/user/update")
	public UserEntity updateUser(@RequestBody UserEntity userEntity) {

		userRepository.save(userEntity);// id present
		return userEntity;
	}
}
