#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template

Feature: Log in to account
AS A Customer
I WANT TO be able to log in to my account

@tag6
Scenario: Log in and go to account page
	Given I have gone to the start page
		And I have logged in to an existing account
		Then I go to the My Account page
		Then I verify that I am in the My Account page
	
@tag7
Scenario: Log in with wrong password
	Given I have gone to the start page
	Then I open the login tab
	And I enter a username and a wrong password
	Then I submit the login info
	Then I verify that an error message about the login appears
	