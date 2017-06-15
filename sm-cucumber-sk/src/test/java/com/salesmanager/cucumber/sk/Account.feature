@selenium
Feature: Account
	IN ORDER TO save my data and see old orders
	AS A user
	I WANT TO be able register an account

@tag
Scenario: Sign In with valid credentials
Given I am on main page
When I sign in with valid credentials
Then I will be successfully logged in

@tag
Scenario: Try to sign in with invalid credentials
Given I dont have a registered account
When I try to sign in with invalid credentials
Then I should be denied logging in

@tag
Scenario: Register account
Given I dont have a registered account
When I create an account
Then An account should be created