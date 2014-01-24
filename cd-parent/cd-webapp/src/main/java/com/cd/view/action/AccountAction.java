package com.cd.view.action;

import com.cd.view.action.vo.UserVO;
import com.cd.view.maker.VOMaker;
import com.opensymphony.xwork2.ActionSupport;
import com.vince.cd.service.SystemService;

public class AccountAction extends ActionSupport {
	private static final long serialVersionUID = 9095941596334253909L;
	private UserVO user;
	private double money;
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

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String deposit() throws Exception {
		user.getAccount().setAmount(systemService.deposit(user.getAccount().getId(), money));
		return SUCCESS;
	}
	
	public String withdraw() throws Exception {
		user.getAccount().setAmount(systemService.withdraw(user.getAccount().getId(), money));
		return SUCCESS;
	}
	
	public String getDetail() throws Exception {
		user = VOMaker.populateVO(systemService.getUserDetail(user.getUsername()));
		return SUCCESS;
	}
}
