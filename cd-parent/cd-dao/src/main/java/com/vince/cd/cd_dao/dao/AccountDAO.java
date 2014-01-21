package com.vince.cd.cd_dao.dao;


public interface AccountDAO {
	double deposit(int accountNumber, double money) throws Exception;
	double withdraw(int accountNumber, double money) throws Exception;
	double getBalance(int accountNumber) throws Exception;
}
