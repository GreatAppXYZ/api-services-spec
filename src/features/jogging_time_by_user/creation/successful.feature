Feature: Successful Jogging Time By User Creation
  Background:
    Given Admin user sends login request

  Scenario: Admin provides correct jogging time by user information
    Given Admin creates USER
    Given Admin provides correct jogging time by user information
    When Admin sends create jogging time by user request for last created user
    Then The response should be successful

  Scenario: Admin provides correct jogging time by user information
    Given Admin creates USER
    Given Admin provides jogging time by user with date in the past
    When Admin sends create jogging time by user request for last created user
    Then The response should be successful
