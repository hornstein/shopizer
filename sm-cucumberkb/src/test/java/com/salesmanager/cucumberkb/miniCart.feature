@selenium

Feature: I want to see if opening the cart works

	In order to be able to see my cart
	As a customer
	I want to be able click on cart
	
	Scenario: Click on cart
	
		Given I am on the startpage
		When I click on the cart
		Then The cart details are shown
		