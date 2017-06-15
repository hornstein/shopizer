@selenium
Feature: SearchFunction
	IN ORDER to find products in the shop
	AS A user
	I WANT to be able to search for products
	
@tag
Scenario: Search for products
Given I am somewhere on main page
When I use the search function to find a product
Then I will be shown a list of search results