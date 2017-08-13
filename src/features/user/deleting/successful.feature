Feature: Successful User Deleting
  Background:
    Given Admin user sends login request

  Scenario: Admin deletes user successfully
    Given Admin creates user
    When Admin deletes last created user
    Then The response should be successful

  Scenario: Manager deletes user successfully
    Given Admin creates MANAGER with email "manager1@greatapp.xyz"
    And Manager sends login request with email "manager1@greatapp.xyz"
    And Manager creates user with email "user1@greatapp.xyz"
    When Manager deletes last created user
    Then The response should be successful
