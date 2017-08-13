Feature: Successful Jogging Time Updating
  Background:
    Given User sends registration request
    And User sends login request

#Date format: DD-MM-YYYY
  Scenario: User updates date successfully
    Given User registers jogging time for "27-7-2017"
    When User updates last created jogging time with date "25-6-2017"
    Then The response should be successful
    And The response should contain "1" as object

  Scenario: User updates distance and time successfully
    Given User registers jogging time with 100 as distance and 6 as time
    When User updates last create jogging time with 50 as distance and 3 as time
    Then The response should be successful
    And The response should contain "1" as object
