package com.cd.view.action;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features = "classpath:features/account", glue = {"com.cd.view.action", "cucumber.api.spring"})
public class AccountActionAcceptTest {
}