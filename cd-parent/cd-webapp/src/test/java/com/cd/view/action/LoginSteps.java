package com.cd.view.action;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.cd.view.action.vo.UserVO;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration("classpath:cucumber.xml")
public class LoginSteps {
	@Autowired
	private UserAction userAction;
	private String result;
	
	@Given("^My username is \"([^\"]*)\"$")
	public void My_username_is_and_password_is(String arg1) throws Throwable {
		UserVO user = new UserVO();
		user.setUsername(arg1);
		userAction.setUser(user);
	}
	
	@And("^password is \"([^\"]*)\"$")
	public void password_is(String arg1) throws Throwable {
		userAction.getUser().setPassword(arg1);
	}
	
	@Given("^This is my username and password:$")
	public void This_is_my_username_and_password(DataTable arg1) throws Throwable {
		List<UserVO> userList = arg1.asList(UserVO.class);
		userAction.setUser(userList.get(0));
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
	
	@Then("^Nothing response$")
	public void Nothing_response() throws Throwable {
		assertEquals("success", result);
		assertEquals(null, userAction.getUser());
	}
}
