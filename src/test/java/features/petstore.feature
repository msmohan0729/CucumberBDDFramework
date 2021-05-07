Feature: PetStore Page test

Scenario: Register an user in the PetStore Page
	Given the user is already in the petstore homepage
	Then the user is in the registration menu
	Then the user enters the required details for account creation 
	Then the user enters his username and password for signin
	And click on the sign in button
	Then the user selects fish for ordering
	Then the user adds the selected fish to the cart
	Then the user checkout the fish by entering the payment details
	Then the user successfully places the order

	