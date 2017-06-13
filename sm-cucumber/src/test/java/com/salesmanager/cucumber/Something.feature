#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template
@selenium
Feature: Shop test
	Test of basic functions in the shop

Scenario: Add a book from startpage
Given I am on the start page
When I add a book
Then It shows up in shopping cart

Scenario: Check out from startpage
Given I am on the start page
And I add a book
And It shows up in shopping cart
When I click check out
Then I am taken to the check out page

Scenario: Change quantity on order page
Given I am on the start page
And I add a book
And It shows up in shopping cart
And I click check out
And I am taken to the check out page
When I change quatity in cart
Then The total is updated accordingly

Scenario: Continue shopping from order page
Given I am on the start page
And I add a book
And It shows up in shopping cart
And I click check out
And I am taken to the check out page
When I click continue shopping
Then I am taken to the start page
   
Scenario: Go to register user from startpage
Given I am on the start page
And I click Sign In
When I click Not yet registered
Then I am taken to the register page
    