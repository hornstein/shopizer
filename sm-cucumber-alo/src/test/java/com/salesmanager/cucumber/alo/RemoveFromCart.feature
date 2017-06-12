

@selenium_6
Feature: remove item from cart
IN ORDER TO check out with the items i want to buy
AS A customer
I WANT TO remove an item from cart

Scenario: remove item from cart
Given i have two items in cart
When i remove one of them
Then i have only one left
