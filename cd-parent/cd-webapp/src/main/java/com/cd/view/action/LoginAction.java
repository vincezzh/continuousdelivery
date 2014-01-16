package com.cd.view.action;

import com.cd.view.action.vo.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 9095941596334253909L;
	private User user;
	private String message;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
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
		message = user.getUsername() + " login Successful!";
		return SUCCESS;
	}
}
