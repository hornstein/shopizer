@selenium
Feature: I want to see if select books works

			In order to be able to buy a book
			As a customer
			I want to be able to select a book
			
			Scenario: select a book
			Given I am on start page
			When I select Spring in action
			Then The book I selected is placed in the shoppingcart

			Scenario: select two books
			Given I am on start page
			When I select Spring in action and The big Switch
			Then The books I selected is placed in the shoppingcart
			
