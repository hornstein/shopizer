@selenium
Feature: Add items to cart
	IN ORDER TO buy products using the website
	AS A user
	I WANT TO able to add an item to the shoppingcart and continue to checkout 

@tag
Scenario: Add item to cart
Given the user is on the main page
When adding the item to the cart
Then the user should be able to checkout via the mincart