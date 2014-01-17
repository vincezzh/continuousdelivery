package com.cd.view.action;

import static org.junit.Assert.assertEquals;

import org.apache.struts2.StrutsSpringJUnit4TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.opensymphony.xwork2.ActionProxy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-struts.xml" })
public class LoginActionTest extends StrutsSpringJUnit4TestCase<LoginAction> {

	@Test
	public void testExecute() throws Exception {
		request.setParameter("user.username", "cdtester");
		request.setParameter("user.password", "abc123");
		ActionProxy proxy = getActionProxy("/login.action");
		LoginAction loginAction = (LoginAction) proxy.getAction();
		String result = proxy.execute();
		assertEquals("success", result);
		assertEquals("cdtester login Successful", loginAction.getMessage());
	}
}
