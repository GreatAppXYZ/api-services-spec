Feature: Unsuccessful User Creation

  Scenario: Admin attempts to create user with existing email
    Given Admin user sends login request
    And Admin creates MANAGER with email "manager1@greatapp.xyz"
    When Admin creates MANAGER with email "manager1@greatapp.xyz"
    Then The response should NOT be successful
    And The response should contain message "email.already.in.use"

  Scenario: Admin provides empty email for user creation
    Given Admin user sends login request
    And Admin provides empty email for user creation
    When Admin sends user creation request
    Then The response should NOT be successful
    And The response should contain message "email.should.not.be.empty"

  Scenario: Admin provides not valid email for user creation
    Given Admin user sends login request
    When Admin creates MANAGER with email "not_valid"
    Then The response should NOT be successful
    And The response should contain message "wrong.email.format"

  Scenario: Admin provides empty role for user creation
    Given Admin user sends login request
    And Admin provides empty role for user creation
    When Admin sends user creation request
    Then The response should NOT be successful
    And The response should contain message "role.should.be.USER.MANAGER.or.ADMIN"

  Scenario: Admin provides incorrect role for user creation
    Given Admin user sends login request
    And Admin provides "ADMINISTRATOR" as role for user creation
    When Admin sends user creation request
    Then The response should NOT be successful
    And The response should contain message "role.should.be.USER.MANAGER.or.ADMIN"

  Scenario: User attempts to create user
    Given User sends registration request
    And User sends login request
    When User provides correct user creation information
    When User sends user creation request
    Then The response should NOT be successful

  Scenario: Admin provides empty password for user creation
    Given Admin user sends login request
    And Admin provides empty password for user creation
    When Admin sends user creation request
    Then The response should NOT be successful
    And The response should contain message "password.should.not.be.empty"

  Scenario: Admin provides null password for user creation
    Given Admin user sends login request
    And Admin provides null password for user creation
    When Admin sends user creation request
    Then The response should NOT be successful
    And The response should contain message "password.should.not.be.empty"

  Scenario: Admin provides short password for user creation
    Given Admin user sends login request
    And Admin provides password "short" for user creation
    When Admin sends user creation request
    Then The response should NOT be successful
    And The response should contain message "password.should.contain.at.least.6.characters"
