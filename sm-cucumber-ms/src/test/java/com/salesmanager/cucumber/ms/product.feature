
Feature: Manage product
This feature deals with the adding and removing of a book

@product
Scenario: find and add a book to the shoppingcart successfully
Given I navigate to the home page
And I choose a book with title contains "google"
And I add the book to the shoppingcart
Then I verify that the book is added to the shoppingcart


@product
Scenario: delete a book from the shoppingcart after being added to it
Given I navigate to the home page
And I choose a book with title contains "google"
And I add the book to the shoppingcart
Then I verify that the book is added to the shoppingcart
When I click on delete th book should desappear from shoppingcart


@product
Scenario: check and place order after adding product to the shopping cart
Given I navigate to the home page
And I choose a book with title contains "google"
And I add the book to the shoppingcart
Then I verify that the book is added to the shoppingcart
Then I checkout 
And I place order

@product
Scenario: use search field to search for a book
Given I navigate to the home page
When The book name is entered in the search field and i click on search the book page should show up
