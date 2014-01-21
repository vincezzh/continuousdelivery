package com.vince.cd.cd_dao.dao.impl;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.vince.cd.cd_dao.dao.UserDAO;
import com.vince.cd.cd_dao.dto.UserDTO;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("classpath:spring-dao.xml")
@TransactionConfiguration(defaultRollback = true)
public class UserDAOImplTest {
	@Resource  
    private UserDAO userDAO;
	
	@Test
	public void login() throws Exception {
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername("cdtester");
		userDTO.setPassword("abc123");
		UserDTO finalUserDTO = userDAO.login(userDTO);
		assertEquals("cdtester", finalUserDTO.getUsername());
		assertEquals(12345, finalUserDTO.getAccount().getId().intValue());
	}
	
	@Test
	public void getUserDetail() throws Exception {
		UserDTO userDetail = userDAO.getDetail("cdtester");
		assertEquals("cdtester", userDetail.getUsername());
		assertEquals(12345, userDetail.getAccount().getId().intValue());
		assertEquals(0, Double.valueOf(userDetail.getAccount().getAmount()).compareTo(100.0));
	}
}
