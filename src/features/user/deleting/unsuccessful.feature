Feature: Unsuccessful User Deleting

  Scenario: Admin deletes user with wrong id
    Given Admin user sends login request
    And Admin creates user
    When Admin deletes last created user with wrong id
    Then The response should NOT be successful

  Scenario: User attempts to delete user
    Given Admin user sends login request
    And Admin creates user with email "user1@greatapp.xyz"
    And User sends login request with email "user1@greatapp.xyz"
    When User deletes last created user
    Then The response should NOT be successful

  Scenario: Admin attempts to delete itself
    Given Admin user sends login request
    And Admin selects admin user
    When User deletes last selected user
    Then The response should NOT be successful
    And The response should contain message "main.admin.should.not.be.deleted"
