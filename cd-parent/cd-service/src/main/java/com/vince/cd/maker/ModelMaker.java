package com.vince.cd.maker;

import com.vince.cd.cd_dao.dto.UserDTO;
import com.vince.cd.model.User;

public class ModelMaker {
	public static User populateModel(UserDTO dto) {
		User model = new User();
		model.setAccountId(dto.getAccountId());
		model.setPassword(dto.getPassword());
		model.setUsername(dto.getUsername());
		return model;
	}
	
	public static UserDTO populateDTO(User model) {
		UserDTO dto = new UserDTO();
		dto.setAccountId(model.getAccountId());
		dto.setPassword(model.getPassword());
		dto.setUsername(model.getUsername());
		return dto;
	}
}
