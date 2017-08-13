Feature: Successful User Updating
  Background:
    Given Admin user sends login request

  Scenario: Admin provides correct update information
    Given Admin creates user with email "user1@greatapp.xyz"
    And Admin updates last created user and sets email to "user2@greatapp.xyz"
    Then The response should be successful
    And The response should contain "1" as object

  Scenario: Admin updates user with same email
    Given Admin creates user with email "user1@greatapp.xyz"
    And Admin updates last created user and sets email to "user1@greatapp.xyz"
    Then The response should be successful
    And The response should contain "1" as object

  Scenario: Manager provides correct update information
    Given Admin creates MANAGER with email "manager1@greatapp.xyz"
    And Manager sends login request with email "manager1@greatapp.xyz"
    And Manager creates user with email "user1@greatapp.xyz"
    And Manager updates last created user and sets email to "user2@greatapp.xyz"
    Then The response should be successful
    And The response should contain "1" as object
