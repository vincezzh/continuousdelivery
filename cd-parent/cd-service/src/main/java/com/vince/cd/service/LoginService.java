package com.vince.cd.service;

import com.vince.cd.model.User;

public interface LoginService {
	User login(User user) throws Exception;
	double getBalance(int accountNumber) throws Exception;
}
