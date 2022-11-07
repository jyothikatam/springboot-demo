package com.primecore.demo.service;

import java.util.List;

import com.primecore.demo.dto.UserDTO;

public interface UserService {

	public UserDTO save(UserDTO userDTO);
	
	public List<UserDTO> getAllUsers();
	
	public UserDTO getById(Long userId);
	
	public UserDTO update(UserDTO userDTO);
	
	public void deleteUser(Long userId);
	
}
