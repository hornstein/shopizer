
@selenium_5
Feature: Place order with non empty cart
IN ORDER TO buy an item
AS A customer
I WANT TO place my order



Scenario: Place order
Given i have item "spring" in cart
	When i go to checkout with "1" copy of "spring"
Then i can place the order

