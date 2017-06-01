Feature: Test usability on shopizer site

@Selenium
Scenario: Test go to defaultStore
Given I am on shopizer website
	And I click on defaultstore
Then I should be on the defaultstore page

@Selenium
Scenario: Test go to business
Given 