Feature: Deposit and Withdraw Money

	Scenario: Deposit money
		Given User's account id is "12345" and he has $"25.10"
		When He deposits his money
		Then His amount should be bigger than $"25.10"
	
	Scenario: Withdraw money
		Given User's account id is "12345" and he has $"15.10"
		When He withdraws his money
		Then His amount should be bigger than $"0.00"