Feature: Successful Password Changing By User

  Background:
    Given Admin user sends login request

  Scenario: Admin updates user's password
    Given Admin creates USER with email "user1@greatapp.xyz" and password "password1"
    When Admin updates password to "newPassword" for last created user
    Then The response should be successful

  Scenario: User can login with new password
    Given Admin creates USER with email "user1@greatapp.xyz" and password "password1"
    And Admin updates password to "newPassword" for last created user
    When User sends login request with email "user1@greatapp.xyz" and password "newPassword"
    Then The response should be successful

  Scenario: Admin updates manager's password
    Given Admin creates MANAGER with email "manager1@greatapp.xyz" and password "password1"
    When Admin updates password to "newPassword" for last created user
    Then The response should be successful

  Scenario: Manager can login with new password
    Given Admin creates MANAGER with email "manager1@greatapp.xyz" and password "password1"
    And Admin updates password to "newPassword" for last created user
    When Manager sends login request with email "manager1@greatapp.xyz" and password "newPassword"
    Then The response should be successful

  Scenario: Admin updates user's password
    Given Admin creates ADMIN with email "admin1@greatapp.xyz" and password "password1"
    When Admin updates password to "newPassword" for last created user
    Then The response should be successful

  Scenario: User can login with new password
    Given Admin creates ADMIN with email "admin1@greatapp.xyz" and password "password1"
    And Admin updates password to "newPassword" for last created user
    When Admin sends login request with email "admin1@greatapp.xyz" and password "newPassword"
    Then The response should be successful

  Scenario: Manager updates user's password
    Given Admin creates MANAGER with email "manager1@greatapp.xyz" and password "passManager"
    And Admin creates USER with email "user1@greatapp.xyz" and password "passUser"
    And Manager sends login request with email "manager1@greatapp.xyz" and password "passManager"
    When Manager updates password to "newPassUser" for last created user using verification password "passManager"
    Then The response should be successful

  Scenario: User can login with password updated by manager
    Given Admin creates MANAGER with email "manager1@greatapp.xyz" and password "passManager"
    And Admin creates USER with email "user1@greatapp.xyz" and password "passUser"
    And Manager sends login request with email "manager1@greatapp.xyz" and password "passManager"
    And Manager updates password to "newPassUser" for last created user using verification password "passManager"
    When User sends login request with email "user1@greatapp.xyz" and password "newPassUser"
    Then The response should be successful
