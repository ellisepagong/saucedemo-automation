Feature: Checkout Scenarios

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
