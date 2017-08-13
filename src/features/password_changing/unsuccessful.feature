Feature: Unsuccessful Password Changing

  Scenario: User provides incorrect current password
    Given User sends registration request with "user1@greatapp.xyz" as username and "password1" as password
    And User sends login request with email "user1@greatapp.xyz" and password "password1"
    When User sends password change request with current password "incorrect" and new password "password2"
    Then The response should NOT be successful
    And The response should contain message "incorrect.current.password"

  Scenario: User provides empty new password
    Given User sends registration request with "user1@greatapp.xyz" as username and "password1" as password
    And User sends login request with email "user1@greatapp.xyz" and password "password1"
    When User sends password change request with current password "password1" and new password ""
    Then The response should NOT be successful
    And The response should contain message "new.password.should.not.be.empty"

  Scenario: User provides short new password
    Given User sends registration request with "user1@greatapp.xyz" as username and "password1" as password
    And User sends login request with email "user1@greatapp.xyz" and password "password1"
    When User sends password change request with current password "password1" and new password "short"
    Then The response should NOT be successful
    And The response should contain message "password.should.contain.at.least.6.characters"

  Scenario: User provides null new password
    Given User sends registration request with "user1@greatapp.xyz" as username and "password1" as password
    And User sends login request with email "user1@greatapp.xyz" and password "password1"
    When User sends password change request with current password "password1" and null new password
    Then The response should NOT be successful
    And The response should contain message "new.password.should.not.be.empty"
