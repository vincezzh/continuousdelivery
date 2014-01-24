package com.cd.view.action;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.cd.view.action.vo.UserVO;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration("classpath:spring-struts.xml")
public class UserActionSteps {
	@Autowired
	private UserAction userAction;
	private String result;
	
	@Given("^My username is \"([^\"]*)\" and password is \"([^\"]*)\"$")
	public void My_username_is_and_password_is(String arg1, String arg2) throws Throwable {
		UserVO user = new UserVO();
		user.setUsername(arg1);
		user.setPassword(arg2);
		userAction.setUser(user);
	}

	@When("^I login with my username and password$")
	public void I_login_with_my_username_and_password() throws Throwable {
		result = userAction.login();
	}

	@Then("^I get my account id$")
	public void I_get_my_account_id() throws Throwable {
		assertEquals("success", result);
		assertEquals(12345, userAction.getUser().getAccount().getId());
	}
}
