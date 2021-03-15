package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	
	
	@Override
	public List<UserDTO> findAll() {
		List<UserEntity> userEntitys = userRepository.findAll();
		List<UserDTO> userDTOs = new ArrayList<>();
		for(UserEntity i : userEntitys ) {
			
			userDTOs.add(userConverter.toUserDTO(i));
		}
		return userDTOs;
	}

	
}
