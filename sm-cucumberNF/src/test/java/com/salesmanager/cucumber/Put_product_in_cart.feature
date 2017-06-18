
@selenium
Feature: Product interaction
	I want to put a product in the shopping cart

@selenium
Scenario: Place a book in the shopping cart
Given I am on the startpage
When I click on the book that is named Spring in Action
	And click on the add to cart button
