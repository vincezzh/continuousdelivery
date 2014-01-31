package com.cd.view.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cd.view.controller.vo.UserVO;
import com.vince.cd.model.Account;
import com.vince.cd.model.User;
import com.vince.cd.service.SystemService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring-servlet.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class})
public class UserControllerTest {
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Mock
	private SystemService systemService;
	
	@InjectMocks
	private UserController userController;

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		User userParam = new User();
		userParam.setUsername("cdtester");
		userParam.setPassword("abc123");
		User userReturn = new User();
		userReturn.setUsername("cdtester");
		Account account = new Account();
		account.setId(12345);
		userReturn.setAccount(account);
		Mockito.when(systemService.login(userParam)).thenReturn(userReturn);
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void login() throws Exception {
		MvcResult result = mockMvc.perform((post("/login.do").param("username", "cdtester").param("password", "abc123")))
				.andExpect(status().isOk())
				.andExpect(model().attribute("message", "cdtester login Successful"))
				.andExpect(model().attributeExists("user"))
				.andReturn();
		
		Assert.assertEquals(((UserVO)(result.getModelAndView().getModel().get("user"))).getUsername(), "cdtester");
		Assert.assertEquals(((UserVO)(result.getModelAndView().getModel().get("user"))).getAccount().getId(), 12345);
	}

}