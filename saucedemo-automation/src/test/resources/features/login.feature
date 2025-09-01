

Feature: Various Log-in scenarios

  @IncorrectCredentials @Regression
  Scenario: Incorrect Credentials
    Given I am on the home page
    When I enter "standard_user" and "secret_sauce" in login details
    And I click login
    Then error message should appear

  @Regression
  Scenario: Locked Out User
    Given I am on the home page
    When I enter "locked_out_user" and "secret_sauce" in login details
    And I click login
    Then error message should appear