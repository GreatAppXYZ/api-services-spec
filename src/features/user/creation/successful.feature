Feature: Successful User Updating
  Background:
    Given Admin user sends login request

  Scenario: Admin provides correct creation information
    Given Admin provides correct user creation information
    When Admin sends user creation request
    Then The response should be successful

  Scenario: Manager provides correct creation information
    Given Admin creates MANAGER with email "manager1@greatapp.xyz"
    And Manager sends login request with email "manager1@greatapp.xyz"
    When Manager provides correct user creation information
    And Manager sends user creation request
    Then The response should be successful

  Scenario: User can login with new account
    Given Admin creates USER with email "user1@greatapp.xyz" and password "password1"
    When User sends login request with email "user1@greatapp.xyz" and password "password1"
    Then The response should be successful

  Scenario: Manager can login with new account
    Given Admin creates MANAGER with email "manager1@greatapp.xyz" and password "password2"
    When Manager sends login request with email "manager1@greatapp.xyz" and password "password2"
    Then The response should be successful

  Scenario: Admin can login with new account
    Given Admin creates ADMIN with email "admin1@greatapp.xyz" and password "pa$$w0rd"
    When Admin sends login request with email "admin1@greatapp.xyz" and password "pa$$w0rd"
    Then The response should be successful
