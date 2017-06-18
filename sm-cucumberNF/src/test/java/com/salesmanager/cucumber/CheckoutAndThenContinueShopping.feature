
@selenium
Feature: Continue Shopping
	After I have placed a product in the cart and pressed on the checkout button, I want to be able to continue shopping (in case I missed to add a product during this course etc)
@selenium
Scenario: Title of your scenario
Given I am on the startpage 
When I click on the book that is named The big Switch
	And click on the Big Switch's add to cart button
	And I click on the cart symbol on top of the web page
	And I click on the checkout button
	And I click on the continue shopping button
	Then I am directed to the start page
