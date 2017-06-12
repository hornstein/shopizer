
@selenium
Feature: Cart Tests
IN ORDER TO buy an item
AS A customer
I WANT TO add an item in cart


Scenario: Put a book in cart
Given customer is on main page
  When goes to product page "spring"
  And adds item to cart
Then product "spring" is added to cart
