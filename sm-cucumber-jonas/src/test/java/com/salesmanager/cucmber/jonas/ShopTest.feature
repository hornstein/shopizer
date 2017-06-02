Feature: I want to test usability on shopizer site

@Selenium
Scenario: Test go to defaultStore
Given I am on shopizer website
	And I click on defaultstore
Then I should be on the defaultstore page

@Selenium
Scenario: Test go to business
Given I am on shopizer website
And I click on business
Then I should be on the business page

@Selenium
Scenario: Test go to contact us
Given I am on shopizer website
And I click on contact us
Then I should be on contact us page

@Selenium
Scenario: Test signin function
Given I am on shopizer website
And 