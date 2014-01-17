package com.vince.cd.cd_dao.dao.impl;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.vince.cd.cd_dao.dao.BankDAO;
import com.vince.cd.cd_dao.dto.UserDTO;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("classpath:spring-dao.xml")
@TransactionConfiguration(defaultRollback = true)
public class BankDAOImplTest {
	@Resource  
    private BankDAO bankDAO;
	
	@Test
	public void login() throws Exception {
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername("cdtester");
		userDTO.setPassword("abc123");
		UserDTO finalUserDTO = bankDAO.login(userDTO);
		assertEquals(12345, finalUserDTO.getAccountId().intValue());
	}

	@Test
	public void getBalance() throws Exception {
		assertEquals(true, bankDAO.getBalance(12345) >= 0);
	}
	
	@Test
	@Transactional
	public void depositNormally() throws Exception {
		double initAmount = bankDAO.getBalance(12345);
		double amount = bankDAO.deposit(12345, 50);
		assertEquals(0, Double.valueOf(amount).compareTo(initAmount + 50));
		assertEquals(true, amount >= 0);
	}
	
	@Test
	@Transactional
	public void withdrawNormally() throws Exception {
		double initAmount = bankDAO.getBalance(12345);
		double amount = bankDAO.withdraw(12345, 50);
		assertEquals(0, Double.valueOf(amount).compareTo(initAmount - 50));
		assertEquals(true, amount >= 0);
	}
}
