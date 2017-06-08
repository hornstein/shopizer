Feature: this feature deals with the manage of the accounts

@account
Scenario: check to login with valid username and password
Given I navigate to the home page
When I enter "mohamed" as a username and "123456" as a password i should see the name on the top of the page

@account
Scenario: check out my account 
Given I navigate to the home page
When I enter "mohamed" as a username and "123456" as a password i should see the name on the top of the page
Then I should be able to check the useraccount

@account
Scenario: check the logout button
Given I navigate to the home page
When I enter "mohamed" as a username and "123456" as a password i should see the name on the top of the page
Then i click on the logout button