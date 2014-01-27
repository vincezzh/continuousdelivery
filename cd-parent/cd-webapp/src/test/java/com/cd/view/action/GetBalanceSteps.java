package com.cd.view.action;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.cd.view.action.vo.AccountVO;
import com.cd.view.action.vo.UserVO;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration("classpath:cucumber.xml")
public class GetBalanceSteps {
	@Autowired
	private UserAction userAction;
	private String result;
	
	@Given("^Account id is \"([^\"]*)\"$")
	public void Account_id_is(String arg1) throws Throwable {
	    UserVO user = new UserVO();
	    AccountVO account = new AccountVO();
	    account.setId(Integer.valueOf(arg1));
	    user.setAccount(account);
	    userAction.setUser(user);
	}

	@When("^User check his account balance by his account id$")
	public void User_check_his_account_balance_by_his_account_id() throws Throwable {
		result = userAction.getBalance();
	}

	@Then("^He can get his amount \"([^\"]*)\"$")
	public void He_can_get_his_amount_of_account(String arg1) throws Throwable {
		assertEquals("success", result);
	    assertEquals(arg1, userAction.getMessage());
	}

	@When("^It is not a valid account id$")
	public void It_is_not_a_valid_account_id() throws Throwable {
		result = userAction.getBalance();
	}

	@Then("^User gets \"([^\"]*)\"$")
	public void User_gets(String arg1) throws Throwable {
		assertEquals("success", result);
	    assertEquals(arg1, userAction.getMessage());
	}
}
