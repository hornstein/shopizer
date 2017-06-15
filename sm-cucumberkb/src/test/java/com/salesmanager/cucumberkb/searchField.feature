@Selenium

Feature: I want to be able to search for books

In order to be able to find the book I want
As a customer
I want to be able to search for them on the website


Scenario: Use the searchfield
Given I am on the Shopizer website
When I write the name of a book in the searchfield
Then The book shows if it exists in the book database
