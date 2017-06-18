
@selenium
Feature: Product page
	I want to test the functionality on the shopizer website

@selenium
Scenario: Choose a book
Given I am on the startpage
When I click on the book that is named The big Switch
Then I see the product details for that book


