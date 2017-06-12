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

Feature: Review book
	AS A Customer
	I WANT TO be able to write reviews for books

@tag2
Scenario Outline: Write review for book
	Given I have gone to the start page
		And I have logged in to an existing account
		When I choose a book with "<title>" in the title at the start page
		Then I want to press the Details button
	And I verify that I have come to that books page
	Then I want to choose to open the review tab
	And I choose to write a review about the book
	Then I write a text review for the book
	And I give the book a star rating
	When I submit the review
	Then I want to verify that the review has been submitted

	Examples:
	|title|
	|google|
	|node|
	|spring|
