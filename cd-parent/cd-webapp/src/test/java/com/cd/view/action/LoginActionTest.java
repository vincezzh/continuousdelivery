package com.cd.view.action;

import org.apache.struts2.StrutsTestCase;
import org.junit.Test;

import com.opensymphony.xwork2.ActionProxy;

public class LoginActionTest extends StrutsTestCase {
	@Test
    public void testExecute() throws Exception {
        request.setParameter("user.username", "vince");
        request.setParameter("user.password", "123");
        ActionProxy proxy = getActionProxy("/login.action");
        LoginAction loginAction = (LoginAction)proxy.getAction();
        String result = proxy.execute();
        assertEquals("success", result);
        assertEquals("vince login Successful!", loginAction.getMessage());
    }
}
