Feature: Unsuccessful Jogging Time Deleting
  Background:
    Given User sends registration request
    And User sends login request

  Scenario: User deletes created jogging time with wrong id
    Given User registers new jogging time
    When User deletes created jogging time with wrong id
    Then The response should NOT be successful
