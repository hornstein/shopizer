@Selenium

Feature: I want to test the login function

			In order to be able to buy and manage books
			As a customer
			I want to be able to log in

			Scenario: Sign in on the website
			Given I am on the startpage
			When I click on the sign in button
			Then I fill in my username and password to log in
			