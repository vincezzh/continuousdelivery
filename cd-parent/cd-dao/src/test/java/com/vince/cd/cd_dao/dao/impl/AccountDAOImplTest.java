package com.vince.cd.cd_dao.dao.impl;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.vince.cd.cd_dao.dao.AccountDAO;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("classpath:spring-dao.xml")
@TransactionConfiguration(defaultRollback = true)
public class AccountDAOImplTest {
	@Resource  
    private AccountDAO accountDAO;
	
	@Test
	public void getBalance() throws Exception {
		assertEquals(true, accountDAO.getBalance(12345) >= 0);
	}
	
	@Test
	@Transactional
	public void depositNormally() throws Exception {
		double initAmount = accountDAO.getBalance(12345);
		double amount = accountDAO.deposit(12345, 50);
		assertEquals(0, Double.valueOf(amount).compareTo(initAmount + 50));
		assertEquals(true, amount >= 0);
	}
	
	@Test
	@Transactional
	public void withdrawNormally() throws Exception {
		double initAmount = accountDAO.getBalance(12345);
		double amount = accountDAO.withdraw(12345, 50);
		assertEquals(0, Double.valueOf(amount).compareTo(initAmount - 50));
		assertEquals(true, amount >= 0);
	}
}
