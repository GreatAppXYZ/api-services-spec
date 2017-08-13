Feature: Successful Password Changing

  Scenario: User provides correct password changing information
    Given User sends registration request with "user1@greatapp.xyz" as username and "password1" as password
    And User sends login request with email "user1@greatapp.xyz" and password "password1"
    When User sends password change request with current password "password1" and new password "password2"
    Then The response should be successful
    And The response should contain "1" as object

  Scenario: User is able to login with new updated password
    Given User sends registration request with "user1@greatapp.xyz" as username and "password1" as password
    And User sends login request with email "user1@greatapp.xyz" and password "password1"
    When User sends password change request with current password "password1" and new password "password2"
    When User sends login request with email "user1@greatapp.xyz" and password "password2"
    Then The response should be successful
