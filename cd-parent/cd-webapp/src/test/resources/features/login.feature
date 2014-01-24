Feature: Login

Scenario: Login successful
	Given My username is "cdtester" and password is "abc123"
	When I login with my username and password
	Then I get my account id
	
Scenario: Login failed
	Given This is my username and password:
	  | Username      | Password        |
      | cdtester      | 123abc          |
	When I login with my username and password
	Then Nothing response