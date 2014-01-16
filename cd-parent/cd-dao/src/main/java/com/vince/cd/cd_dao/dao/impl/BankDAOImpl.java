package com.vince.cd.cd_dao.dao.impl;

import com.vince.cd.cd_dao.dao.BankDAO;
import com.vince.cd.cd_dao.dto.UserDTO;

public class BankDAOImpl implements BankDAO {
	@Override
	public double deposit(double money) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double withdraw(double money) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getBalance(int accountNumber) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserDTO login(UserDTO userDTO) throws Exception {
		UserDTO userDTOFinal = new UserDTO();
		userDTOFinal.setAccountId(10000);
		userDTOFinal.setUsername(userDTO.getUsername());
		return userDTOFinal;
	}

}
