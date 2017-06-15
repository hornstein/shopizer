@selenium
Feature: Remove item from cart
	IN ORDER TO regret my adding of an item to the cart
	AS A user
	I WANT TO be able to remove an item from the cart

@tag
Scenario: Remove item from cart
Given There is an item in the cart
When I press the remove item-button
Then The item should be removed from the cart