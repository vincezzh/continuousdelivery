package com.vince.cd.service.impl;

import com.vince.cd.cd_dao.dao.AccountDAO;
import com.vince.cd.cd_dao.dao.UserDAO;
import com.vince.cd.maker.ModelMaker;
import com.vince.cd.model.User;
import com.vince.cd.service.SystemService;

public class SystemServiceImpl implements SystemService {
	private AccountDAO accountDAO;
	private UserDAO userDAO;

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User login(User user) throws Exception {
		return ModelMaker.populateModel(userDAO.login(ModelMaker.populateDTO(user)));
	}

	@Override
	public double getBalance(int accountNumber) throws Exception {
		return accountDAO.getBalance(accountNumber);
	}

	@Override
	public double deposit(int accountNumber, double amount) throws Exception {
		return accountDAO.deposit(accountNumber, amount);
	}

	@Override
	public double withdraw(int accountNumber, double amount) throws Exception {
		return accountDAO.withdraw(accountNumber, amount);
	}

	@Override
	public User getUserDetail(String username) throws Exception {
		return ModelMaker.populateModel(userDAO.getDetail(username));
	}

}
