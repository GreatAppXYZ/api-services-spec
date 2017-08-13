Feature: Unsuccessful User Registration

  Scenario: User provides existing email
    Given User sends registration request with username "test@greatapp.xyz"
    When User sends registration request with username "test@greatapp.xyz"
    Then The response should NOT be successful
    And The response should contain message "email.already.in.use"

  Scenario: User provides not valid email
    Given User sends registration request with username "not_valid"
    Then The response should NOT be successful
    And The response should contain message "wrong.email.format"

  Scenario: User provides empty email
    Given User provides empty email
    When User sends registration request
    Then The response should NOT be successful
    And The response should contain message "email.should.not.be.empty"

  Scenario: User provides null email
    Given User provides null email
    When User sends registration request
    Then The response should NOT be successful
    And The response should contain message "email.should.not.be.empty"

  Scenario: User provides empty password
    Given User provides empty password
    When User sends registration request
    Then The response should NOT be successful
    And The response should contain message "password.should.not.be.empty"

  Scenario: User provides null password
    Given User provides null password
    When User sends registration request
    Then The response should NOT be successful
    And The response should contain message "password.should.not.be.empty"

  Scenario: User provides short password
    Given User provides less than 6 characters password
    When User sends registration request
    Then The response should NOT be successful
    And The response should contain message "password.should.contain.at.least.6.characters"
