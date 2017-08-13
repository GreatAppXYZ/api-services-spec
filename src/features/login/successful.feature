Feature: Successful User Login
  Background:
    Given User sends registration request with "test@greatapp.xyz" as username and "secret" as password

  Scenario: User provides correct login credentials
    Given User provides "test@greatapp.xyz" as username and "secret" as password
    When User sends login request
    Then The response should be successful
