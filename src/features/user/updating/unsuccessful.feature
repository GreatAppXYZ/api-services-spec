Feature: Unsuccessful User Updating

  Scenario: Admin attempts to update user with existing email
    Given Admin user sends login request
    And Admin creates USER with email "user1@greatapp.xyz"
    And Admin creates USER with email "user2@greatapp.xyz"
    And Admin updates last created user and sets email to "user1@greatapp.xyz"
    Then The response should NOT be successful
    And The response should contain message "email.already.in.use"

  Scenario: Admin provides empty email for user updating
    Given Admin user sends login request
    And Admin creates USER with email "user1@greatapp.xyz"
    When Admin updates last created user and sets email to ""
    Then The response should NOT be successful
    And The response should contain message "email.should.not.be.empty"

  Scenario: Admin provides not valid email for user updating
    Given Admin user sends login request
    And Admin creates USER with email "user1@greatapp.xyz"
    When Admin updates last created user and sets email to "not_valid"
    Then The response should NOT be successful
    And The response should contain message "wrong.email.format"

  Scenario: Admin provides empty role for user updating
    Given Admin user sends login request
    And Admin creates USER
    When Admin updates last created user and sets role to ""
    Then The response should NOT be successful
    And The response should contain message "role.should.be.USER.MANAGER.or.ADMIN"

  Scenario: Admin provides incorrect role for user updating
    Given Admin user sends login request
    And Admin creates USER
    When Admin updates last created user and sets role to "INCORRECT"
    Then The response should NOT be successful
    And The response should contain message "role.should.be.USER.MANAGER.or.ADMIN"

  Scenario: User attempts to update its own user
    Given Admin user sends login request
    And Admin creates user with email "user1@greatapp.xyz"
    And User sends login request with email "user1@greatapp.xyz"
    And User updates last created user and sets email to "user2@greatapp.xyz"
    Then The response should NOT be successful

  Scenario: User attempts to update other user
    Given Admin user sends login request
    And Admin creates user with email "user1@greatapp.xyz"
    And Admin creates user with email "user2@greatapp.xyz"
    And User sends login request with email "user2@greatapp.xyz"
    And User updates last created user and sets email to "user3@greatapp.xyz"
    Then The response should NOT be successful
