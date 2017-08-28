

Feature: PoC that my framework works.
@selenium




@tag1
Scenario: Adding google book to cart
Given I navigated to the shopizer-site
When I Click on googlebook
	And I click on 'add to cart googlebook'
Then I validate that the google book is added to the shoppingcart
And I assert that its in the cart with the correct price Google.


@tag2
Scenario: Adding spring book to cart
Given I navigated to the shopizer-site
When I click on springbook
And I click on 'add to cart springBook'
Then I validate that the spring book is added to the cart
And I assert that the book is in the cart with the correct price Spring

@tag3
Scenario: Adding node book to cart
Given I navigated to the shopizer-site
When I click on nodebook
And I click on 'add to cart nodebook'
Then I validate that the node book is added to the cart
And I assert that its in the cart with the correct price Node.

@tag4
Scenario: Testing business-navigation
Given I navigated to the shopizer-site
When I click on business-link
And I assert that we landed on the correct page.

@tag5
Scenario: TestingTheBiggerGoogleBookImage
Given I navigated to the shopizer-site
When I Click on googlebook
And I scroll down on that page
Then I assert that we're on the right page, and the googlebook image has enlarged

@tag6
Scenario: TestingTheBiggerSpringBookImage
Given I navigated to the shopizer-site
When I click on springbook
And I scroll down on that page
Then I assert that we're on the right page, and the springbook image has enlarged

@tag7
Scenario: TestingTheBiggerNodeBookImage
Given I navigated to the shopizer-site
When I click on nodebook
And I scroll down on that page
Then I assert that we're on the right page, and the nodebook image has enlarged

@tag8
Scenario: Adding paas book to cart
Given I navigated to the shopizer-site
When I click on paasbook
And I click on 'add to cart paasbook'
Then I validate that the paas book has been added to the cart
And I assert that the book is in the cart, and the right price for paas book

@tag9
Scenario: TestingTheBiggerPaasBookImage
Given I navigated to the paasbookURL
And I scroll down on that page
And I click on the paasbook
Then I scrolldown and assert that paasbook image is enlarged

@tag10
Scenario: TestingTheContactFormLulz
Given I navigated to the shopizer-site
Then I do a specialscrolling on that page to click contactform
Then I click on the contactform link and encounter a javascript-alert-error
