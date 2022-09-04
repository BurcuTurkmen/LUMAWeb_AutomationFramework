Feature: Purchase Functionality

  Background:
    Given User is on login page
    When User enter valid credentials
    Then User should login successfully

    Scenario: Purchase a product
      When User select a product
      Then User added product to cart message should be displayed

    Scenario: Checkout process
      Then User proceed to checkout
      Then Success checkout message should be displayed
