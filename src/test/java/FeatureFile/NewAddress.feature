Feature: New Address Functionality

  Background:
    Given User is on login page
    When User enter valid credentials
    Then User should login successfully

  Scenario Outline: Add New Address
    When User navigate to My Account page
    Then User click on Manage Addresses
    Then User add a new address and fill "<phoneNumber>" and "<streetAddress>" and "<city>" and "<state>" and "<zipCode>"
    Then Success message should be displayed

    Examples:
      | phoneNumber  | streetAddress | city         | state     | zipCode |
      | 8476789082   | BlueWater Str | Libertyville | Illinois  | 60048   |