package com.vince.cd.maker;

import com.vince.cd.cd_dao.dto.AccountDTO;
import com.vince.cd.cd_dao.dto.UserDTO;
import com.vince.cd.model.Account;
import com.vince.cd.model.User;

public class ModelMaker {
	public static User populateModel(UserDTO dto) {
		if(dto == null)
			return null;
		
		User model = new User();
		model.setPassword(dto.getPassword());
		model.setUsername(dto.getUsername());
		if(dto.getAccount() != null)
			model.setAccount(populateModel(dto.getAccount()));
		return model;
	}
	
	public static UserDTO populateDTO(User model) {
		UserDTO dto = new UserDTO();
		dto.setPassword(model.getPassword());
		dto.setUsername(model.getUsername());
		if(model.getAccount() != null)
			dto.setAccount(populateDTO(model.getAccount()));
		return dto;
	}
	
	public static AccountDTO populateDTO(Account model) {
		AccountDTO dto = new AccountDTO();
		dto.setId(model.getId());
		dto.setAmount(model.getAmount());
		return dto;
	}
	
	public static Account populateModel(AccountDTO dto) {
		if(dto == null)
			return null;
		
		Account model = new Account();
		model.setId(dto.getId());
		model.setAmount(dto.getAmount());
		return model;
	}
}
