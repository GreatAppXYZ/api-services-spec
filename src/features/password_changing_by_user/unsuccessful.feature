Feature: Successful Password Changing By User

  Background:
    Given Admin user sends login request

  Scenario: Admin sends incorrect verification password
    And Admin creates USER with email "user1@greatapp.xyz" and password "password1"
    And Admin updates password to "newPassword" for last created user with wrong admin password
    Then The response should NOT be successful

  Scenario: Admin provides empty new password
    And Admin creates USER with email "user1@greatapp.xyz" and password "password1"
    And Admin updates password to "" for last created user
    Then The response should NOT be successful
    And The response should contain message "new.password.should.not.be.empty"

  Scenario: Admin provides null new password
    And Admin creates USER with email "user1@greatapp.xyz" and password "password1"
    And Admin updates password to null for last created user
    Then The response should NOT be successful
    And The response should contain message "new.password.should.not.be.empty"

  Scenario: Admin provides short new password
    And Admin creates USER with email "user1@greatapp.xyz" and password "password1"
    And Admin updates password to "short" for last created user
    Then The response should NOT be successful
    And The response should contain message "new.password.should.contain.at.least.6.characters"

  Scenario: Manager attempts to update other manager's password
    Given Admin creates MANAGER with email "managerOne@greatapp.xyz" and password "passOneManager"
    And Admin creates MANAGER with email "managerTwo@greatapp.xyz" and password "passTwoManager"
    And Manager sends login request with email "managerOne@greatapp.xyz" and password "passOneManager"
    When Manager updates password to "NewPassTwoManager" for last created user using verification password "passOneManager"
    Then The response should NOT be successful

  Scenario: Manager attempts to update admin password
    Given Admin creates MANAGER with email "manager@greatapp.xyz" and password "passManager"
    And Admin creates ADMIN with email "newAdmin@greatapp.xyz" and password "passAdmin"
    And Manager sends login request with email "manager@greatapp.xyz" and password "passManager"
    When Manager updates password to "newAdminPass" for last created user using verification password "passManager"
    Then The response should NOT be successful

  Scenario: Manager attempts to updates user's password with incorrect verification password
    Given Admin creates MANAGER with email "manager1@greatapp.xyz" and password "passManager"
    And Admin creates USER with email "user1@greatapp.xyz" and password "passUser"
    And Manager sends login request with email "manager1@greatapp.xyz" and password "passManager"
    When Manager updates password to "newPassUser" for last created user using verification password "incorrect"
    Then The response should NOT be successful

  Scenario: User attempts to update other user's password
    Given Admin creates USER with email "userOne@greatapp.xyz" and password "passOneUser"
    And Admin creates USER with email "userTwo@greatapp.xyz" and password "passTwoUser"
    And User sends login request with email "userOne@greatapp.xyz" and password "passOneUser"
    When User updates password to "newPassword" for last created user using verification password "passOneUser"
    Then The response should NOT be successful
