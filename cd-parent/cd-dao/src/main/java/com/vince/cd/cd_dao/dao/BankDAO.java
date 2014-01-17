package com.vince.cd.cd_dao.dao;

import com.vince.cd.cd_dao.dto.UserDTO;

public interface BankDAO {
	UserDTO login(UserDTO userDTO) throws Exception;
	double deposit(int accountNumber, double money) throws Exception;
	double withdraw(int accountNumber, double money) throws Exception;
	double getBalance(int accountNumber) throws Exception;
}
