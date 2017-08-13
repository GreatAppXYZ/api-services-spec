Feature: Unsuccessful User Login
  Background:
    Given User sends registration request with "test@greatapp.xyz" as username and "secret" as password

  Scenario: User provides incorrect email
    Given User provides "incorrect@greatapp.xyz" as username and "secret" as password
    When User sends login request
    Then The response should NOT be successful

  Scenario: User provides null email
    Given User provides null username and "secret" as password
    When User sends login request
    Then The response should NOT be successful

  Scenario: User provides incorrect password
    Given User provides "test@greatapp.xyz" as username and "incorrect" as password
    When User sends login request
    Then The response should NOT be successful


  Scenario: User provides null password
    Given User provides "test@greatapp.xyz" username and null password
    When User sends login request
    Then The response should NOT be successful
