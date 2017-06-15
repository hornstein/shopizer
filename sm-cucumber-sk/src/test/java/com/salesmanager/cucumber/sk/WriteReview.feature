@selenium
Feature: Write a review
	IN ORDER to give tips to other customers
	AS A customer
	I WANT to be able to review products

@tag
Scenario: Write a review
Given I am signed in with new account
And browse to a specific product
When I write a review
Then The review should be saved and displayed to me
