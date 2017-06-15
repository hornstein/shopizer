@Selenium

Feature: I want to see if the selection of books work

			In order to be able to buy a book
			As a customer
			I want to be able to select a book

			Scenario: Select a book
			Given I am on the startpage
			When I select the book "The Big Switch" by clicking on it
			Then The book is selected and put in the shopping cart
			
			
@Selenium

			Scenario: Select another book
			Given I am on the startpage
			When I select the book "Spring in Action" by clicking on it
			Then The book is selected and put in the shopping cart
			
			
@Selenium

			Scenario: Select yet another book
			Given I am on the startpage
			When I select the book "Node Web Development" by clicking on it
			Then The book is selected and put in the shopping cart