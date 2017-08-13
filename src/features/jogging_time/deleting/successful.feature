Feature: Successful Jogging Time Deleting
  Background:
    Given User sends registration request
    And User sends login request

  Scenario: User deletes jogging time successfully
    Given User registers new jogging time
    When User deletes last created jogging time
    Then The response should be successful
