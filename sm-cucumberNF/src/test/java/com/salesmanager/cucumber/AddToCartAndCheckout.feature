
Feature: Add to cart and checkout
	I want to use this template for my feature file

@selenium
Scenario: Checkout Test
Given I am on the startpage
When I click on the book that is named The big Switch
	And click on the Big Switch's add to cart button
	And I click on the cart symbol on top of the web page
	And I click on the checkout button
Then I am directed to the checkout page


