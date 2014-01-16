package com.cd.view.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring-servlet.xml" })
public class LoginControllerTest {
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void login1() throws Exception {
		mockMvc.perform((post("/login.do")))
				.andExpect(status().isOk())
				.andDo(print());
	}

	@Test
	public void login2() throws Exception {
		mockMvc.perform((post("/login.do")))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(model().attributeExists("message"));
	}

	@Test
	public void login3() throws Exception {
		mockMvc.perform((post("/login.do").param("username", "vince").param("password", "123")))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(model().attribute("message", "vince login Successful"));
	}

}