@selenium
Feature: Place order
	I want to add a product and then place the order

@selenium
Scenario: Place order
Given I am on the startpage
When I click on the book that is named The big Switch
	And click on the Big Switch's add to cart button
	And I click on the cart symbol on top of the web page
	And I click on the checkout button
	And I click on the place order button
	Then I am redirected to the checkout confirmation page
