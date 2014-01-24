Feature: Get Balance

Scenario: Get Balance successful
	Given Account id is "12345"
	When User check his account balance by his account id
	Then He can get his amount "$100.00"
	
Scenario: Get Balance failed
	Given Account id is "54321"
	When It is not a valid account id
	Then User gets "$0.00"