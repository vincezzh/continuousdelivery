Feature: Login

Scenario: Login successful
	Given My username is "cdtester" and password is "abc123"
	When I login with my username and password
	Then I get my account id