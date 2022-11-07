package com.primecore.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primecore.demo.dto.UserDTO;
import com.primecore.demo.entities.User;
import com.primecore.demo.repository.UserRepository;
import com.primecore.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	ModelMapper modelMapper = new ModelMapper();

	public UserDTO save(UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		User userRes = userRepository.save(user);
		UserDTO uDto = modelMapper.map(userRes, UserDTO.class);
		return uDto;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> userDTOs = userRepository.findAll();
		List<UserDTO> uList = new ArrayList<UserDTO>();
		for (int i = 0; i < userDTOs.size(); i++) {
			UserDTO userDTO = new UserDTO();
			userDTO = modelMapper.map(userDTOs.get(i), UserDTO.class);
			uList.add(userDTO);
		}
		return uList;
	}

	@Override
	public UserDTO getById(Long userId) {
		UserDTO userDTO = null;
		User user = userRepository.getById(userId);
		userDTO = modelMapper.map(user, UserDTO.class);
		return userDTO;
	}

	@Override
	public UserDTO update(UserDTO userDTO) {
		User user = null;
		Optional<User> userRes = userRepository.findById(userDTO.getUserId());
		if (userRes != null) {
			user = userRes.get();
		}
		user.setName(userDTO.getName());
		user.setUserName(userDTO.getUserName());
		User user2 = userRepository.save(user);
		UserDTO uDto = modelMapper.map(user2, UserDTO.class);
		return uDto;
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);

	}

}
