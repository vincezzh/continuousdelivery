Feature: Get User Detail

	Scenario: Get user detail
		Given Get username "cdtester"
		When Apply for detail
		Then The user get detail below:
		| Username      | Password   | AccountId  | Amount | 
        | cdtester      | abc123     | 12345      | 160.15 |