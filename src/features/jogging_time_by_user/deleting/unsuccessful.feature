Feature: Unsuccessful Jogging Time By User Deleting

  Scenario: User attempts to delete jogging time by user
    Given Admin user sends login request
    And Admin creates USER with email "user1@greatapp.xyz"
    And Admin creates jogging time by user for last created user
    And User sends login request with email "user1@greatapp.xyz"
    When User deletes last created jogging time for last created user
    Then The response should NOT be successful

  Scenario: Manager attempts to delete jogging time by user
    Given Admin user sends login request
    And Admin creates MANAGER with email "manager1@greatapp.xyz"
    And Admin creates jogging time by user for last created user
    And Manager sends login request with email "manager1@greatapp.xyz"
    When Manager deletes last created jogging time for last created user
    Then The response should NOT be successful
