package com.cd.view.action;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features = "classpath:features/account", glue = {"com.cd.view.action", "cucumber.api.spring"})
//@CucumberOptions(features = "classpath:features/account", glue = {"com.cd.view.action", "cucumber.api.spring"}, format={"pretty", "html:target/cucumber", "json:target/cucumber/cucumber.json"})
public class AccountActionAcceptTest {
}