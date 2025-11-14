Feature: Testing Cart Persistence

  @Regression @SWAG-009
  Scenario: Cart Persistence on Log Out
    Given I am on the home page
    When I enter "standard_user" and "secret_sauce" in login details
    And I click login
    Then I should be in inventory page
    When I add the following items to cart
      | Sauce Labs Backpack  |
      | Sauce Labs Bike Light|
    And I go to cart
    Then I verify cart contents
      | Sauce Labs Backpack  |
      | Sauce Labs Bike Light|
    And I log out
    Then I should be on the home page
    When I enter "standard_user" and "secret_sauce" in login details
    And I click login
    Then I should be in inventory page
    And I go to cart
    Then I verify cart contents
      | Sauce Labs Backpack  |
      | Sauce Labs Bike Light|


  @Regression @SWAG-009
  Scenario: Cart Persistence on Navigation
    Given I am on the home page
    When I enter "standard_user" and "secret_sauce" in login details
    And I click login
    Then I should be in inventory page
    When I add the following items to cart
      | Sauce Labs Backpack  |
      | Sauce Labs Bike Light|
    And I go to cart
    Then I verify cart contents
      | Sauce Labs Backpack  |
      | Sauce Labs Bike Light|
    And I log out
    When I enter "standard_user" and "secret_sauce" in login details
    And I click login
    And I should be in inventory page
    And I go to cart
    Then I verify cart contents
      | Sauce Labs Backpack  |
      | Sauce Labs Bike Light|