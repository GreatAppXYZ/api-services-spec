Feature: Successful Jogging Time By User Updating
  Background:
    Given Admin user sends login request

#Date format: DD-MM-YYYY
  Scenario: Admin updates jogging times by user date successfully
    Given Admin creates USER
    And Admin creates jogging time by user request for last created user with date "27-6-2017"
    When Admin updates last created jogging time by user with date "25-6-2017"
    Then The response should be successful
    And The response should contain "1" as object

  Scenario: Admin updates distance and time successfully
    Given Admin creates USER
    And Admin creates jogging time by user request for last created user with distance 1200 and time 40
    When Admin updates last created jogging time by user with distance 9000 and time 50
    Then The response should be successful
    And The response should contain "1" as object
