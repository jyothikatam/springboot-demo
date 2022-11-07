package com.primecore.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.primecore.demo.dto.UserDTO;
import com.primecore.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/user/add")
	public UserDTO addUser(@RequestBody UserDTO userDTO) {
		UserDTO uDto = userService.save(userDTO);
		return uDto;
	}
	
	@GetMapping("/user/list")
	public List<UserDTO> getAll() {
		List<UserDTO> uDtos = userService.getAllUsers();
		return uDtos;
	}

	
	@GetMapping("/user/get/{userId}")
	public UserDTO getById(@PathVariable("userId") Long userId) {
		UserDTO uDtos = userService.getById(userId);
		return uDtos;
	}
	
	@PutMapping("/user/update")
	public UserDTO updateUser(@RequestBody UserDTO userDTO) {
		UserDTO uDto = userService.update(userDTO);
		return uDto;
	}
	
	@GetMapping("/user/delete/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		userService.deleteUser(userId);
	}

}
