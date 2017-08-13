Feature: Successful User Registration

  Scenario: User provides correct information
    Given User provides correct registration information
    When User sends registration request
    Then The response should be successful
