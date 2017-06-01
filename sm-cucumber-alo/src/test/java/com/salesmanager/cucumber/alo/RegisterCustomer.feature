
@selenium
Feature: Customer registration
  IN ORDER TO store my user information
  AS A Custmer
  I WANT TO be able to register my profile

Scenario: Register new customer
  Given the user is logged out
  When the user register with "Kalle"
  Then the user should receive a greeting with "Kalle"

