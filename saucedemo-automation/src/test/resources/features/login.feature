Feature: Various Log-in scenarios

  @Smoke @SWAG-001
  Scenario: Successful Log-in
    Given I am on the home page
    When I enter "standard_user" and "secret_sauce" in login details
    And I click login
    Then I should be in inventory page

  @Regression
  Scenario Outline: <Scenario>
    Given I am on the home page
    When I enter "<username>" and "<password>" in login details
    And I click login
    Then login error message should be "<message>"

  @SWAG-002
  Examples:
   | Scenario         | username      | password     | message          |
   | Missing Username |               | secret_sauce | MISSING_USERNAME |
   | Missing Password | standard_user |              | MISSING_PASSWORD |

  @SWAG-003
  Examples:
    | Scenario              | username       | password      | message               |
    | Incorrect Credentials |  falseUsername | falsePassword | INCORRECT_CREDENTIALS |

  @SWAG-004
  Examples:
    | Scenario       | username         | password     | message    |
    | Locked Out User|  locked_out_user | secret_sauce | LOCKED_OUT |