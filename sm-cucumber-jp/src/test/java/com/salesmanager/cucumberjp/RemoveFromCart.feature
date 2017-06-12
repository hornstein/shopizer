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
@tag
Feature: Remove books from the cart
	AS A Customer
	I WANT TO be able to remove books from the cart
	
@tag3
Scenario Outline: Remove book from cart at the startpage
	Given I have gone to the start page
	Then I choose a book with "<title>" in the title at the start page
	Then I add the book to my cart
	Then I open the cart tab
	When The cart tab is open
	Then I click the button to remove the book twice
	Then I verify that the cart in the tab is empty
	
	Examples:
	|title|
	|google|
	|node|
	|spring|

@tag4
Scenario Outline: Remove book from cart at the checkout page
	Given I have gone to the start page
	Then I choose a book with "<title>" in the title at the start page
	Then I add the book to my cart
	Then I open the cart tab
	When The cart tab is open
	Then I click the checkout button on the cart tab
	When I verify that I am on the checkout page
	Then I click the button to remove the book from the cart in checkout
	Then I verify that I am taken to an error site about book removal
	Then I verify that the cart in the tab is empty
	
	Examples:
	|title|
	|google|
	|node|
	|spring|