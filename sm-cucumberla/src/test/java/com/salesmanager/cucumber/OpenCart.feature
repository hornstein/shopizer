@Selenium

Feature: I want to put see that the major purchase flow works

			In order to buy a book
			As a customer
			I want to be able to purchase a book
			
			Scenario: Flow of purchasing a book
			Given I am on the startpage
			When I have chosen a book and put it in the cart
			Then I purchase the book by checking out
			
			
@Selenium

			Scenario: Flow of purchasing a book
			Given I am on the startpage
			When I have chosen a book and put it in the cart
			Then I remove the book from the cart again