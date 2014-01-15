package com.vince.cd.cd_dao.dao;

public interface BankDAO {
	double deposit(double money) throws Exception;
	double withdraw(double money) throws Exception;
	double getBalance(int accountNumber) throws Exception;
}
