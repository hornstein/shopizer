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

Feature: Total price of books in cart
AS A Customer
I WANT TO be able to see the total price of books I have placed in the cart

@tag5
Scenario Outline: Verify correct total price of books in cart
	Given I have gone to the start page
	Then I choose a book with "<title>" in the title at the start page
	Then I add the book to my cart
	Then I open the cart tab
	When The cart tab is open
	Then I click the checkout button on the cart tab
	When I verify that I am on the checkout page
	Then I verify that the price for one book is <price>
	And I increase the number of copies of that book in the cart
	And I press the button for recalculating the price
	Then I verify that the listed total price is the sum of the books in the cart

	Examples:
	|title|price|
	|google|18.99|
	|node|29.99|
	|spring|39.99|