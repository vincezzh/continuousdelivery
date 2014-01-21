package com.vince.cd.service;

import com.vince.cd.model.User;

public interface SystemService {
	User login(User user) throws Exception;
	double getBalance(int accountNumber) throws Exception;
	double deposit(int accountNumber, int amount) throws Exception;
	double withdraw(int accountNumber, int amount) throws Exception;
	User getUserDetail(String username) throws Exception;
}
