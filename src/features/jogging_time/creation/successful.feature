Feature: Successful Jogging Time Creation
  Background:
    Given User sends registration request
    And User sends login request

  Scenario: User provides correct jogging time information
    Given User provides correct jogging time information
    When User sends create jogging time request
    Then The response should be successful

  Scenario: User provides date in the past
    Given User provides date in the past
    When User sends create jogging time request
    Then The response should be successful
