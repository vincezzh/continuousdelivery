package com.cd.view.maker;

import com.cd.view.action.vo.AccountVO;
import com.cd.view.action.vo.UserVO;
import com.vince.cd.model.Account;
import com.vince.cd.model.User;

public class VOMaker {
	public static User populateModel(UserVO vo) {
		User model = new User();
		model.setPassword(vo.getPassword());
		model.setUsername(vo.getUsername());
		if(vo.getAccount() != null)
			model.setAccount(populateModel(vo.getAccount()));
		return model;
	}
	
	public static UserVO populateVO(User model) {
		if(model == null)
			return null;
		
		UserVO vo = new UserVO();
		vo.setPassword(model.getPassword());
		vo.setUsername(model.getUsername());
		if(model.getAccount() != null)
			vo.setAccount(populateVO(model.getAccount()));
		return vo;
	}
	
	public static AccountVO populateVO(Account model) {
		if(model == null)
			return null;
		
		AccountVO vo = new AccountVO();
		vo.setId(model.getId());
		if(model.getAmount() != null)
			vo.setAmount(model.getAmount());
		return vo;
	}
	
	public static Account populateModel(AccountVO vo) {
		Account model = new Account();
		model.setId(vo.getId());
		model.setAmount(vo.getAmount());
		return model;
	}
}
