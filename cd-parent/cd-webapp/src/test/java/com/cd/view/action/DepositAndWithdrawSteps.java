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
public class DepositAndWithdrawSteps {
	@Autowired
	private AccountAction accountAction;
	private String result;
	
	@Given("^User's account id is \"([^\"]*)\" and he has \\$\"([^\"]*)\"$")
	public void User_s_account_id_is_and_he_has_$(String arg1, String arg2) throws Throwable {
	    UserVO user = new UserVO();
	    AccountVO account = new AccountVO();
	    account.setId(Integer.valueOf(arg1));
	    user.setAccount(account);
	    accountAction.setUser(user);
	    accountAction.setMoney(Double.valueOf(arg2));
	}

	@When("^He deposits his money$")
	public void He_deposits_his_money() throws Throwable {
	    result = accountAction.deposit();
	}
	
	@When("^He withdraws his money$")
	public void He_withdraws_his_money() throws Throwable {
		result = accountAction.withdraw();
	}

	@Then("^His amount should be bigger than \\$\"([^\"]*)\"$")
	public void His_amount_should_be_bigger_than_$(String arg1) throws Throwable {
		assertEquals("success", result);
	    assertEquals(true, accountAction.getUser().getAccount().getAmount() >= Double.valueOf(arg1));
	}
}
