package com.vince.cd.service.impl;

import com.vince.cd.cd_dao.dao.BankDAO;
import com.vince.cd.maker.ModelMaker;
import com.vince.cd.model.User;
import com.vince.cd.service.LoginService;

public class LoginServiceImpl implements LoginService {
	private BankDAO bankDAO;

	public void setBankDAO(BankDAO bankDAO) {
		this.bankDAO = bankDAO;
	}

	@Override
	public User login(User user) throws Exception {
		return ModelMaker.populateModel(bankDAO.login(ModelMaker.populateDTO(user)));
	}

	@Override
	public double getBalance(int accountNumber) throws Exception {
		return bankDAO.getBalance(accountNumber);
	}

}
