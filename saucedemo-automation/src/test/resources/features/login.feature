Feature: Various Log-in scenarios

  @IncorrectCredentials
  Scenario: Incorrect Credentials
    Given I am on the home page
    When I enter "falseUsername" and "falsePassword" in login details
    And I click login
    Then error message should appear