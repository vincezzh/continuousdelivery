package com.cd.view.action;

import java.math.BigDecimal;

import com.cd.view.action.vo.UserVO;
import com.cd.view.maker.VOMaker;
import com.opensymphony.xwork2.ActionSupport;
import com.vince.cd.service.SystemService;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 9095941596334253909L;
	private UserVO user;
	private String message;
	private SystemService systemService;

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
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

	public String login() throws Exception {
		user = VOMaker.populateVO(systemService.login(VOMaker.populateModel(user)));
		if(user != null)
			message = user.getUsername() + " login Successful";
		return SUCCESS;
	}
	
	public String getBalance() throws Exception {
		user.getAccount().setAmount(systemService.getBalance(user.getAccount().getId()));
		
		message = "$" + new BigDecimal(user.getAccount().getAmount()).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		return SUCCESS;
	}
}
