Feature: Unsuccessful Jogging Time Creation
  Background:
    Given User sends registration request
    And User sends login request

  Scenario: User provides incorrect day of the month
    Given User provides 30 as day, 2 as month and 2017 as year
    When User sends create jogging time request
    Then The response should NOT be successful
    And The response should contain message "invalid.date"

  Scenario: User provides null day
    Given User provides null day
    When User sends create jogging time request
    Then The response should NOT be successful
    And The response should contain message "invalid.date"

  Scenario: User provides null month
    Given User provides null month
    When User sends create jogging time request
    Then The response should NOT be successful
    And The response should contain message "invalid.date"

  Scenario: User provides null year
    Given User provides null year
    When User sends create jogging time request
    Then The response should NOT be successful
    And The response should contain message "invalid.date"

  Scenario: User provides future date
    Given User provides future date
    When User sends create jogging time request
    Then The response should NOT be successful
    And The response should contain message "invalid.future.date"
