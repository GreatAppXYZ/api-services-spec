Feature: Unsuccessful Jogging Time By User Listing

  Background:
    Given Admin user sends login request

  Scenario: User tries to list jogging times by user
    Given Admin creates USER with email "user1@greatapp.xyz"
    And Admin registers jogging time by user for "27-7-2017" for last created user
    And User sends login request with email "user1@greatapp.xyz"
    When User sends request to get jogging times by user from "24-7-2017" to "31-7-2017" for last created user
    Then The response should NOT be successful


  Scenario: Manager tries to list jogging times by user
    Given Admin creates MANAGER with email "manager1@greatapp.xyz"
    And Admin registers jogging time by user for "27-7-2017" for last created user
    And Manager sends login request with email "manager1@greatapp.xyz"
    When Manager sends request to get jogging times by user from "24-7-2017" to "31-7-2017" for last created user
    Then The response should NOT be successful
