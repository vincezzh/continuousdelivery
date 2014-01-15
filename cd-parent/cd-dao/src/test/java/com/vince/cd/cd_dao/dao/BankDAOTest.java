package com.vince.cd.cd_dao.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.vince.cd.cd_dao.dao.impl.BankDAOImpl;

public class BankDAOTest {
	private static BankDAO bankDAO = new BankDAOImpl();

	@Test
	public void deposit() throws Exception {
		assertEquals(0, Double.compare(100, bankDAO.deposit(100)));
	}

	@Test
	public void withdraw() throws Exception {
		assertEquals(0, Double.compare(0, bankDAO.withdraw(100)));
	}
	
	@Test
	public void getBalance() throws Exception {
		fail("Not yet implemented");
	}
}
