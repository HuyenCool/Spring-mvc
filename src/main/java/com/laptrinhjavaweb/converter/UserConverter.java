package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;

@Component
public class UserConverter {

	public UserDTO toUserDTO(UserEntity userEntity) {

		UserDTO userDTO = new UserDTO();

		userDTO.setUserName(userEntity.getUserName());
		userDTO.setPassWord(userEntity.getPassWord());

		return userDTO;

	}
}
