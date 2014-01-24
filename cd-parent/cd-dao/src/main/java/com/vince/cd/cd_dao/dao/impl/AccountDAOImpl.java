package com.vince.cd.cd_dao.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.vince.cd.cd_dao.dao.AccountDAO;

public class AccountDAOImpl implements AccountDAO {
	private JdbcTemplate jdbcTemplate;  
	  
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
        this.jdbcTemplate = jdbcTemplate;  
    }
    
	@Override
	public double deposit(int accountNumber, double money) throws Exception {
		double amount = getBalance(accountNumber) + money;
		String sql = "UPDATE zaccount SET amount=? WHERE id=?";  
        jdbcTemplate.update(sql, new Object[] { amount, accountNumber });
		return getBalance(accountNumber);
	}

	@Override
	public double withdraw(int accountNumber, double money) throws Exception {
		double amount = getBalance(accountNumber) - money;
		String sql = "UPDATE zaccount SET amount=? WHERE id=?";  
        jdbcTemplate.update(sql, new Object[] { amount, accountNumber });
		return getBalance(accountNumber);
	}

	@Override
	public double getBalance(int accountNumber) throws Exception {
		String sql = "select amount from zaccount where id=?";
		Double amount = 0.0;
		try {
			amount = jdbcTemplate.queryForObject(sql, new Object[] { accountNumber }, Double.class);
		}catch(Exception e) {}
		return amount;
	}

}
