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
And I click on signin
And I fill in password and username
And I click on login
Then I should get an error message

@Selenium
Scenario: Test sortby function
Given I am under businesslink in shopizer website
And I click on sortby
Then I should se Name

@Selenium
Scenario: Test add to cart function
Given I am on shopizer website
And I click on add to cart
And I click on open cart
Then I check that the book is added

@Selenium
Scenario: Test the checkout function
Given I am on sp website
And I add the book Node Web Development
And I click on open cart and checkout
Then I review my order

@Selenium
Scenario: Test remove function
Given I am on shopizer website
And I add a book
And I click on open cart to see the added book
And I click on remove
Then I receive and error message

@Selenium
Scenario: Test remove book
Given I am on shopizer website
And I add book Node WD
And I open cart
And I click on x to remove book
Then Book should be removed