Feature: Unsuccessful User Listing
  Background:
    Given User sends registration request
    And User sends login request

  Scenario: User should not see user listings
    When User sends request to list users
    Then The response should NOT be successful

  Scenario: Newly created user should not see user listings
    Given Admin user sends login request
    And Admin creates USER with email "user1@greatapp.xyz"
    And User sends login request with email "user1@greatapp.xyz"
    When User sends request to list users
    Then The response should NOT be successful
