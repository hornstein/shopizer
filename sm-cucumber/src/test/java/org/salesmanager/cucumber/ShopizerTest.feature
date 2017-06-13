Feature: Testing functions on shopizer
	I want to use this template for my feature file

@Selenium
Scenario: Add to cart
Given I am at the home page on Shopizer
When I Click on the book The Big Switch
And I click on the add to cart button
And I open the cart
Then I validate that the book is in the shopping cart

@Selenium
Scenario: CheckWebBooks
Given I am at the home page on Shopizer
And I click on computer books
And Click on button Web
Then I verify i am on that page

@Selenium
Scenario: CollectionTest
Given I am at the home page on Shopizer
And I Click computer books
And I click on cbooks
And I Click on the author
Then I verify i only see books from him

@Selenium
Scenario: Sort by test
Given I am at the home page on Shopizer
And I click on computer books
And I click on cbooks
And I click on sort by
And I select price
Then I verify they are ordered by price

@Selenium
Scenario: Remove from cart at mainpage
Given I am at the home page on Shopizer
And I Click on the book The Big Switch
And I click on the add to cart button
And I open the cart
And I remove the book from the cart
And I open the cart
And I remove the book from the cart
Then I verify the book is removed

@Selenium
Scenario: Test checkout
Given I am at the home page on Shopizer
And I Click on the book The Big Switch
And I click on the add to cart button
And I open the cart
And I click on checkout
Then I verify i am in checkout