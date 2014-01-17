package com.cd.view.maker;

import com.cd.view.action.vo.UserVO;
import com.vince.cd.model.User;

public class VOMaker {
	public static User populateModel(UserVO vo) {
		User model = new User();
		model.setAccountId(vo.getAccountId());
		model.setPassword(vo.getPassword());
		model.setUsername(vo.getUsername());
		return model;
	}
	
	public static UserVO populateVO(User model) {
		UserVO vo = new UserVO();
		vo.setAccountId(model.getAccountId());
		vo.setPassword(model.getPassword());
		vo.setUsername(model.getUsername());
		return vo;
	}
}
