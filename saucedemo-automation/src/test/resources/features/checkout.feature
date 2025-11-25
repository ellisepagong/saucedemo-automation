Feature: Checkout Scenarios

#  Tests concerning the checkout page and checkout procedure.
#
#  Test Cases included:
#  Successful Purchase (Full Checkout Procedure)
#  Missing credentials at Checkout
#  Verify Price Calculation
#  Verify Checkout proceeds with empty cart
#  Verify Checkout Fields not responding with problem user profile
#  Verify longer load time with performance glitch user profile
#  Verify visual bugs in visual user profile


  @Smoke @SWAG-018
    Scenario: Successful Purchase
    Given I am on the home page
    When I enter "standard_user" and "secret_sauce" in login details
    And I click login
    Then I should be in inventory page
    When I add the following items to cart
      | Sauce Labs Backpack  |
      | Sauce Labs Bike Light|
    And I go to cart
    Then I should be in cart page
    And I go to checkout
    Then I should be in checkout Page
    When I enter "firstname", "lastname" and "1800" in your information
    Then I should be in overview page
    Then I verify cart contents and price
      | Sauce Labs Backpack  |
      | Sauce Labs Bike Light|
    And I finish checkout
    Then transaction should be successful

  @Regression @SWAG-007
  Scenario Outline: Missing <Credential> at Checkout
    Given I am on the home page
    When I enter "standard_user" and "secret_sauce" in login details
    And I click login
    Then I should be in inventory page
    When I add the following items to cart
      | Sauce Labs Backpack  |
      | Sauce Labs Bike Light|
    And I go to cart
    Then I should be in cart page
    And I go to checkout
    Then I should be in checkout Page
    When I enter "<firstname>", "<lastname>" and "<postal code>" in your information
    Then I should get the error message "<message>"

  Examples:
    |Credential|firstname|lastname|postal code|message                    |
    |First Name|         |lastname|1800       |CHECKOUT_FIRSTNAME_REQUIRED|
    |Last Name |firstname|        |1800       |CHECKOUT_LASTNAME_REQUIRED |
    |Zip Code  |firstname|lastname|           |CHECKOUT_POSTAL_REQUIRED   |

  @Regression @SWAG-010
  Scenario: Verify Price Calculation
    Given I am on the home page
    When I enter "standard_user" and "secret_sauce" in login details
    And I click login
    Then I should be in inventory page
    When I add the following items to cart
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    And I go to cart
    Then I should be in cart page
    And I go to checkout
    Then I should be in checkout Page
    When I enter "firstname", "lastname" and "1800" in your information
    Then I should be in overview page
    Then I verify cart contents and price
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |

  @Negative @Regression @SWAG-008
  Scenario: Verify Checkout Proceeds with Empty Cart
    Given I am on the home page
    When I enter "standard_user" and "secret_sauce" in login details
    And I click login
    Then I should be in inventory page
    And I go to cart
    Then I should be in cart page
    And I go to checkout
    Then I should be in checkout Page
    When I enter "firstname", "lastname" and "1800" in your information
    Then I should be in overview page
    And I finish checkout
    Then transaction should be successful

  @Negative @Regression @SWAG-016
  Scenario: Verify Checkout Fields not responding with Problem User
    Given I am on the home page
    When I enter "problem_user" and "secret_sauce" in login details
    And I click login
    Then I should be in inventory page
    And I go to cart
    Then I should be in cart page
    And I go to checkout
    Then I should be in checkout Page
    Then I enter "firstname", "lastname" and "1800" in checkout information and verify

  @Negative @Regression @SWAG-021
  Scenario: Verify longer load time in Performance Glitch User
    Given I am on the home page
    When I enter "performance_glitch_user" and "secret_sauce" in login details
    And I click login
    Then I wait for Inventory to load
    And I go to cart
    Then I should be in cart page
    And I go to back to inventory from cart page
    Then I wait for Inventory to load
    When I add the following items to cart
      | Sauce Labs Backpack  |
      | Sauce Labs Bike Light|
    And I go to cart
    Then I should be in cart page
    And I go to checkout
    Then I should be in checkout Page
    When I enter "firstname", "lastname" and "1800" in your information
    Then I should be in overview page
    Then I verify cart contents and price
      | Sauce Labs Backpack  |
      | Sauce Labs Bike Light|
    And I finish checkout
    Then transaction should be successful
    And I go back to home
    Then I wait for Inventory to load

  @Negative @Regression @SWAG-020
  Scenario: Verify UI Elements incorrect in Visual Error User
    Given I am on the home page
    When I enter "visual_user" and "secret_sauce" in login details
    And I click login
    Then I should be in inventory page
    Then I verify catalog items are priced incorrectly
      | Item Name                         | Item Description     | Item Price |
      | Sauce Labs Backpack               | BACKPACK_DESC        | $29.99     |
      | Sauce Labs Bike Light             | BIKELIGHT_DESC       | $9.99      |
      | Sauce Labs Bolt T-Shirt           | BOLTSHIRT_DESC       | $15.99     |
      | Sauce Labs Fleece Jacket          | JACKET_DESC          | $49.99     |
      | Sauce Labs Onesie                 | ONESIE_DESC          | $7.99      |
      | Test.allTheThings() T-Shirt (Red) | TESTTHINGSSHIRT_DESC | $15.99     |
    Then I verify images are incorrect
    Then I verify inventory UI is not correct
    And I go to cart
    Then I verify cart UI is not correct
