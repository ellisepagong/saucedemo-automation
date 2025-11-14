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

  @Regression @SWAG-006
  Scenario: Verify sort reverse alphabetical
    Given I am on the home page
    When I enter "standard_user" and "secret_sauce" in login details
    And I click login
    Then I should be in inventory page
    When I sort catalog by "za"
    Then I verify the following items in catalog
      | Item Name                         | Item Description     | Item Price |
      | Test.allTheThings() T-Shirt (Red) | TESTTHINGSSHIRT_DESC | $15.99     |
      | Sauce Labs Onesie                 | ONESIE_DESC          | $7.99      |
      | Sauce Labs Fleece Jacket          | JACKET_DESC          | $49.99     |
      | Sauce Labs Bolt T-Shirt           | BOLTSHIRT_DESC       | $15.99     |
      | Sauce Labs Bike Light             | BIKELIGHT_DESC       | $9.99      |
      | Sauce Labs Backpack               | BACKPACK_DESC        | $29.99     |


  @Regression @SWAG-006
  Scenario: Verify sort Price Low to High
    Given I am on the home page
    When I enter "standard_user" and "secret_sauce" in login details
    And I click login
    Then I should be in inventory page
    When I sort catalog by "lohi"
    Then I verify the following items in catalog
      | Item Name                         | Item Description     | Item Price |
      | Sauce Labs Onesie                 | ONESIE_DESC          | $7.99  |
      | Sauce Labs Bike Light             | BIKELIGHT_DESC       | $9.99  |
      | Sauce Labs Bolt T-Shirt           | BOLTSHIRT_DESC       | $15.99 |
      | Test.allTheThings() T-Shirt (Red) | TESTTHINGSSHIRT_DESC | $15.99 |
      | Sauce Labs Backpack               | BACKPACK_DESC        | $29.99 |
      | Sauce Labs Fleece Jacket          | JACKET_DESC          | $49.99 |

  @Regression @SWAG-006
  Scenario: Verify sort Price High to Low
    Given I am on the home page
    When I enter "standard_user" and "secret_sauce" in login details
    And I click login
    Then I should be in inventory page
    When I sort catalog by "hilo"
    Then I verify the following items in catalog
      | Item Name                         | Item Description     | Item Price |
      | Sauce Labs Fleece Jacket          | JACKET_DESC          | $49.99 |
      | Sauce Labs Backpack               | BACKPACK_DESC        | $29.99 |
      | Sauce Labs Bolt T-Shirt           | BOLTSHIRT_DESC       | $15.99 |
      | Test.allTheThings() T-Shirt (Red) | TESTTHINGSSHIRT_DESC | $15.99 |
      | Sauce Labs Bike Light             | BIKELIGHT_DESC       | $9.99  |
      | Sauce Labs Onesie                 | ONESIE_DESC          | $7.99  |

#  @Regression @SWAG-011
#  Scenario: Verify images broken when problem user logged in
#    Given I am on the home page
#    When I enter "problem_user" and "secret_sauce" in login details
#    And I click login
#    Then I should be in inventory page
#    Then I verify images not displaying

