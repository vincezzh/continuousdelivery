package com.cd.view.action;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features = "classpath:features/user")
//@CucumberOptions(features = "classpath:features/user", format={"pretty", "html:target/cucumber", "json:target/cucumber/cucumber.json"})
public class UserActionAcceptTest {
}