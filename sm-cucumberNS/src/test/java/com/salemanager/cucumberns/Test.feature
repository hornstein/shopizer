@selenium
Feature: Contact shopizer
  IN ORDER TO send my contact request
  AS A Custmer
  I WANT TO be able to fill out the contact form

  @test
  Scenario: Register new customer
    Given the user is in home page
    When the user enter Contact us
    And the user remove the error
    And the user give name "Kalle"
    And the user give Email address "Kalle@yahoo.nu"
    And the user give Subject "Kalle is back"
    And the user give Coments "Kalle have a quation"
    And the user  enter send
    Then the user get confirmation

  Scenario: Change the amount of books
    Given the user is in home page
    When the user choose the book
    And the user go to chart
    And the user go to checkout
    And the user chenge quantity to ten
    Then the total price is changed

  Scenario: Check Cart
    Given the user is in the home page
    When the user find the book
    And the user add book to chart
    And the user is in cahrt
    Then the user compair if exixt

  Scenario: CONTINUE SHOPPIN
    Given the user is in the home page
    When the user find the book
    And the user add book to chart
    And the user is in cahrt
    And the user go to checkout
    Then the user in in th amin page;
