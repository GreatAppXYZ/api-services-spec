Feature: Successful Jogging Time By User Deleting
  Background:
    Given Admin user sends login request

  Scenario: Admin deletes jogging time successfully
    Given Admin creates USER
    And Admin creates jogging time by user for last created user
    When Admin deletes last created jogging time for last created user
    Then The response should be successful
