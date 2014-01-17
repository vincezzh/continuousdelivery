package com.cd.view.action;

import com.cd.view.action.vo.UserVO;
import com.cd.view.maker.VOMaker;
import com.opensymphony.xwork2.ActionSupport;
import com.vince.cd.service.LoginService;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 9095941596334253909L;
	private UserVO user;
	private String message;
	private LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String execute() throws Exception{
		UserVO finalUser = VOMaker.populateVO(loginService.login(VOMaker.populateModel(user)));
		message = finalUser.getUsername() + " login Successful";
		return SUCCESS;
	}
}
