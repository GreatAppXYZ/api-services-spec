Feature: Unsuccessful Jogging Time Updating
  Background:
    Given User sends registration request
    And User sends login request

#Date format: DD-MM-YYYY
  Scenario: User updates date with wrong date
    Given User registers jogging time for "27-7-2017"
    When User updates last created jogging time with date "32-13-2017"
    Then The response should NOT be successful

  Scenario: User updates date with wrong jogging time id
    Given User registers jogging time for "27-7-2017"
    When User updates jogging time with wrong id
    Then The response should NOT be successful
