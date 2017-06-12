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

Feature: Use the Category page
IN ORDER TO find books
AS A Customer
I WANT TO be able to use the Category page

#Steg 3 här (When I choose a book...) resulterar för mig i en
#WebDriverException: Failed to decode from marionette.
#Vet ej hur jag ska lösa det
@tag8
Scenario Outline: Go to book page from category page
	Given I have gone to the start page
	Then I want to go to the Category page
	When I choose a book whose title contains "<title>" from the Category page
	Then I want to press the Details button
	And I verify that I have come to that books page

	Examples:
	|title|
	|node|
	|spring|