Feature: Various Log-in scenarios

  @Regression @SWAG-003
  Scenario: Incorrect Credentials
    Given I am on the home page
    When I enter "falseUsername" and "falsePassword" in login details
    And I click login
    Then login error message should be "Epic sadface: Username and password do not match any user in this service"

  @Regression @SWAG-004
  Scenario: Locked Out User
    Given I am on the home page
    When I enter "locked_out_user" and "secret_sauce" in login details
    And I click login
    Then login error message should be "Epic sadface: Sorry, this user has been locked out."