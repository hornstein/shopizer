@selenium_7
Feature: Search for book title
IN ORDER TO find a book title
AS A user
I WANT TO	find the title when i search for it


Scenario: Search for book title
Given customer starts on main page
When customer enters "Node Web Development" in search bar
Then product page "Node Web Development" is shown

