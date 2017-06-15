@Selenium

Feature: I want to test the main page on the Shopizer site

    	In order to go to the main page
    	As a customer
    	I want to be able to see the main page
    	
    	Scenario: Visit main page
    	Given I am on the startpage
    	When I click on the Default store button
    	Then I should see the main page