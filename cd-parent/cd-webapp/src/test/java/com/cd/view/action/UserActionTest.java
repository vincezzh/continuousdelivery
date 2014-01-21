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
import com.vince.cd.service.SystemService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-struts.xml" })
public class UserActionTest extends StrutsSpringJUnit4TestCase<UserAction> {

	@Test
	public void login() throws Exception {
		request.setParameter("user.username", "cdtester");
		request.setParameter("user.password", "abc123");
		ActionProxy proxy = getActionProxy("/login.action");
		UserAction userAction = (UserAction) proxy.getAction();
		
		User userParam = new User();
		userParam.setUsername("cdtester");
		userParam.setPassword("abc123");
		User userReturn = new User();
		userReturn.setUsername("cdtester");
		userReturn.setAccountId(12345);
		SystemService systemService = Mockito.mock(SystemService.class);
		Mockito.when(systemService.login(userParam)).thenReturn(userReturn);
		userAction.setSystemService(systemService);
		
		String result = proxy.execute();
		assertEquals("success", result);
		assertEquals("cdtester login Successful", userAction.getMessage());
	}
	
	@Test
	public void getBalance() throws Exception {
		request.setParameter("user.accountId", "12345");
		ActionProxy proxy = getActionProxy("/getBalance.action");
		UserAction userAction = (UserAction) proxy.getAction();

		SystemService systemService = Mockito.mock(SystemService.class);
		Mockito.when(systemService.getBalance(12345)).thenReturn(50.00);
		userAction.setSystemService(systemService);

		String result = proxy.execute();
		assertEquals("success", result);
		assertEquals("$50.0", userAction.getMessage());
	}
}
