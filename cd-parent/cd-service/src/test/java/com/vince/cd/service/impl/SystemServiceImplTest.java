package com.vince.cd.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.vince.cd.cd_dao.dao.AccountDAO;
import com.vince.cd.cd_dao.dao.UserDAO;
import com.vince.cd.cd_dao.dao.impl.AccountDAOImpl;
import com.vince.cd.cd_dao.dao.impl.UserDAOImpl;
import com.vince.cd.cd_dao.dto.AccountDTO;
import com.vince.cd.cd_dao.dto.UserDTO;
import com.vince.cd.model.User;

@RunWith(MockitoJUnitRunner.class)
public class SystemServiceImplTest {
	@InjectMocks
	private SystemServiceImpl systemService;
	@Mock
	private UserDAO userDAO =  new UserDAOImpl();
	@Mock
	private AccountDAO accountDAO =  new AccountDAOImpl();
	
	@Test
	public void login() throws Exception {
		UserDTO userDTOParam = new UserDTO();
		userDTOParam.setUsername("cdtester");
		userDTOParam.setPassword("abc123");
		UserDTO userDTOReturn = new UserDTO();
		userDTOReturn.setUsername("cdtester");
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId(12345);
		userDTOReturn.setAccount(accountDTO);
		Mockito.when(userDAO.login(userDTOParam)).thenReturn(userDTOReturn);
		
		User user = new User();
		user.setUsername("cdtester");
		user.setPassword("abc123");
		User userReturn = systemService.login(user);
		assertEquals("cdtester", userReturn.getUsername());
		assertEquals(12345, userReturn.getAccount().getId().intValue());
	}
	
	@Test
	public void getDetail() throws Exception {
		UserDTO userDTOReturn = new UserDTO();
		userDTOReturn.setUsername("cdtester");
		userDTOReturn.setPassword("abc123");
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId(12345);
		accountDTO.setAmount(100.0);
		userDTOReturn.setAccount(accountDTO);
		Mockito.when(userDAO.getDetail("cdtester")).thenReturn(userDTOReturn);
		
		User user = systemService.getUserDetail("cdtester");
		assertEquals("cdtester", user.getUsername());
		assertEquals("abc123", user.getPassword());
		assertEquals(12345, user.getAccount().getId().intValue());
		assertEquals(0, Double.valueOf(100.0).compareTo(user.getAccount().getAmount()));
	}
	
	@Test
	public void deposit() throws Exception {
		Mockito.when(accountDAO.deposit(12345, 100)).thenReturn(150.0);
		
		double amount = systemService.deposit(12345, 100);
		assertEquals(0, Double.valueOf(150.0).compareTo(amount));
	}
	
	@Test
	public void withdraw() throws Exception {
		Mockito.when(accountDAO.withdraw(12345, 100)).thenReturn(50.0);
		
		double amount = systemService.withdraw(12345, 100);
		assertEquals(0, Double.valueOf(50.0).compareTo(amount));
	}

	@Test
	public void getBalance() throws Exception {
		Mockito.when(accountDAO.getBalance(12345)).thenReturn(100.0);
		
		double amount = systemService.getBalance(12345);
		assertEquals(0, Double.valueOf(100.0).compareTo(amount));
	}
}
