Feature: Unsuccessful Jogging Time Creation

  Background:
    Given Admin user sends login request
    And Admin creates USER

  Scenario: Admin provides incorrect day of the month
    Given Admin provides 30 as day, 2 as month and 2017 as year for jogging time registration by user
    When Admin sends create jogging time by user request for last created user
    Then The response should NOT be successful
    And The response should contain message "invalid.date"

  Scenario: Admin provides null day
    Given Admin provides null day for jogging time registration by user
    When Admin sends create jogging time by user request for last created user
    Then The response should NOT be successful
    And The response should contain message "invalid.date"

  Scenario: Admin provides null month
    Given Admin provides null month for jogging time registration by user
    When Admin sends create jogging time by user request for last created user
    Then The response should NOT be successful
    And The response should contain message "invalid.date"

  Scenario: Admin provides null year
    Given Admin provides null year for jogging time registration by user
    When Admin sends create jogging time by user request for last created user
    Then The response should NOT be successful
    And The response should contain message "invalid.date"

  Scenario: Admin provides future date
    Given Admin provides future date for jogging time by user
    When Admin sends create jogging time by user request for last created user
    Then The response should NOT be successful
    And The response should contain message "invalid.future.date"

  Scenario: User attempts to create jogging time by user
    Given Admin creates USER with email "user1@greatapp.xyz"
    And User sends login request with email "user1@greatapp.xyz"
    And User provides correct jogging time by user information
    When User sends create jogging time by user request for last created user
    Then The response should NOT be successful

  Scenario: Manager attempts to create jogging time by user
    Given Admin creates MANAGER with email "manager1@greatapp.xyz"
    And Manager sends login request with email "manager1@greatapp.xyz"
    And Manager provides correct jogging time by user information
    When Manager sends create jogging time by user request for last created user
    Then The response should NOT be successful
