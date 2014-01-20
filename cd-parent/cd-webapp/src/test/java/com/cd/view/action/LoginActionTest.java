package com.cd.view.action;

import static org.junit.Assert.assertEquals;

import org.apache.struts2.StrutsSpringJUnit4TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.opensymphony.xwork2.ActionProxy;
import com.vince.cd.model.User;
import com.vince.cd.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-struts.xml" })
public class LoginActionTest extends StrutsSpringJUnit4TestCase<LoginAction> {

	@Test
	public void login() throws Exception {
		request.setParameter("user.username", "cdtester");
		request.setParameter("user.password", "abc123");
		ActionProxy proxy = getActionProxy("/login.action");
		LoginAction loginAction = (LoginAction) proxy.getAction();
		
		User userParam = new User();
		userParam.setUsername("cdtester");
		userParam.setPassword("abc123");
		User userReturn = new User();
		userReturn.setUsername("cdtester");
		userReturn.setAccountId(12345);
		LoginService loginService = Mockito.mock(LoginService.class);
		Mockito.when(loginService.login(userParam)).thenReturn(userReturn);
		loginAction.setLoginService(loginService);
		
		String result = proxy.execute();
		assertEquals("success", result);
		assertEquals("cdtester login Successful", loginAction.getMessage());
	}
	
	@Test
	public void getBalance() throws Exception {
		request.setParameter("user.accountId", "12345");
		ActionProxy proxy = getActionProxy("/getBalance.action");
		LoginAction loginAction = (LoginAction) proxy.getAction();

		LoginService loginService = Mockito.mock(LoginService.class);
		Mockito.when(loginService.getBalance(12345)).thenReturn(50.00);
		loginAction.setLoginService(loginService);

		String result = proxy.execute();
		assertEquals("success", result);
		assertEquals("$50.0", loginAction.getMessage());
	}
}
