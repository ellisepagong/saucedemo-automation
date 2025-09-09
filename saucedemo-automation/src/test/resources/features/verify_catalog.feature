Feature: Verify Inventory and Catalog

  @Regression @SWAG-005
  Scenario: Verify Catalog and Product Details
    Given I am on the home page
    When I enter "standard_user" and "secret_sauce" in login details
    And I click login
    Then I should be in inventory page
    Then I verify the following items in catalog
      | Item Name                         | Item Description     | Item Price |
      | Sauce Labs Backpack               | BACKPACK_DESC        | $29.99     |
      | Sauce Labs Bike Light             | BIKELIGHT_DESC       | $9.99      |
      | Sauce Labs Bolt T-Shirt           | BOLTSHIRT_DESC       | $15.99     |
      | Sauce Labs Fleece Jacket          | JACKET_DESC          | $49.99     |
      | Sauce Labs Onesie                 | ONESIE_DESC          | $7.99      |
      | Test.allTheThings() T-Shirt (Red) | TESTTHINGSSHIRT_DESC | $15.99     |