Feature: Successful User Listing
  Background:
    Given Admin user sends login request

  Scenario: Admin should see its own user in listing
    When Admin sends request to list users
    Then The response should be successful
    And The response should contain array object of size 1

  Scenario: Admin should see new created user in listing
    Given Admin creates USER with email "user1@greatapp.xyz"
    When Admin sends request to list users
    Then The response should be successful
    And The response should contain array object of size 2

  Scenario: Manager should admin and its own user
    Given Admin creates MANAGER with email "manager1@greatapp.xyz"
    And Manager sends login request with email "manager1@greatapp.xyz"
    When Manager sends request to list users
    Then The response should be successful
    And The response should contain array object of size 2
