package com.cd.view.action;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.cd.view.action.vo.UserVO;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration("classpath:cucumber.xml")
public class GetUserDetailSteps {
	@Autowired
	private AccountAction accountAction;
	private String result;
	
	@Given("^Get username \"([^\"]*)\"$")
	public void Get_username(String arg1) throws Throwable {
	    UserVO user = new UserVO();
	    user.setUsername(arg1);
	    accountAction.setUser(user);
	}

	@When("^Apply for detail$")
	public void Apply_for_detail() throws Throwable {
	    result = accountAction.getDetail();
	}
	
	@Then("^The user get detail below:$")
	public void The_user_get_detail_below(DataTable arg1) throws Throwable {
	    List<Map<String, String>> valueMap = arg1.asMaps();
	    assertEquals("success", result);
	    assertEquals(valueMap.get(0).get("Username"), accountAction.getUser().getUsername());
	    assertEquals(valueMap.get(0).get("Password"), accountAction.getUser().getPassword());
	    assertEquals(0, Integer.valueOf(valueMap.get(0).get("AccountId")).compareTo(accountAction.getUser().getAccount().getId()));
	}
}
