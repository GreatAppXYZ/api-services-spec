Feature: Unsuccessful Jogging Time By User Updating

  Background:
    Given Admin user sends login request

#Date format: DD-MM-YYYY
  Scenario: Admin updates date with wrong date
    Given Admin creates USER
    And Admin creates jogging time by user request for last created user with date "27-6-2017"
    When Admin updates last created jogging time by user with date "30-2-2017"
    Then The response should NOT be successful

  Scenario: Admin updates date with null day
    Given Admin creates USER
    And Admin creates jogging time by user request for last created user with date "27-6-2017"
    When Admin updates last created jogging time by user with null day
    Then The response should NOT be successful

  Scenario: Admin updates date with null month
    Given Admin creates USER
    And Admin creates jogging time by user request for last created user with date "27-6-2017"
    When Admin updates last created jogging time by user with null month
    Then The response should NOT be successful

  Scenario: Admin updates date with null year
    Given Admin creates USER
    And Admin creates jogging time by user request for last created user with date "27-6-2017"
    When Admin updates last created jogging time by user with null year
    Then The response should NOT be successful

  Scenario: Admin updates date with null year
    Given Admin creates USER
    And Admin creates jogging time by user request for last created user with date "27-6-2017"
    When Admin updates jogging time by user with wrong jogging time id
    Then The response should NOT be successful

  Scenario: Admin updates date with null year
    Given Admin creates USER
    And Admin creates jogging time by user request for last created user with date "27-6-2017"
    When Admin updates jogging time by user with wrong user id
    Then The response should NOT be successful

  Scenario: User attempts to update jogging time by user
    Given Admin creates USER with email "user1@greatapp.xyz"
    And Admin creates jogging time by user request for last created user with date "27-6-2017"
    And User sends login request with email "user1@greatapp.xyz"
    When User updates last created jogging time by user with date "25-6-2017"
    Then The response should NOT be successful

  Scenario: Manager attempts to update jogging time by user
    Given Admin creates MANAGER with email "manager1@greatapp.xyz"
    And Admin creates jogging time by user request for last created user with date "27-6-2017"
    And Manager sends login request with email "manager1@greatapp.xyz"
    When Manager updates last created jogging time by user with date "25-6-2017"
    Then The response should NOT be successful
