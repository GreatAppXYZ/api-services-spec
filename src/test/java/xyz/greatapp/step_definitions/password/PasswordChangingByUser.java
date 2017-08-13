package xyz.greatapp.step_definitions.password;

import cucumber.api.java8.En;
import xyz.greatapp.api.client.holders.LastCreatedUser;
import xyz.greatapp.api.client.requests.api.password.ChangePasswordByUserRequest;

public class PasswordChangingByUser implements En
{
    public PasswordChangingByUser(ChangePasswordByUserRequest changePasswordByUserRequest,
            LastCreatedUser lastCreatedUser)
    {
        When("^Admin updates password to \"([^\"]*)\" for last created user$",
                (String newPassword) -> changePasswordByUserRequest
                        .withVerificationPassword("pa$$w0rd")
                        .withUserId(lastCreatedUser.getUserId())
                        .withNewPasswordForUser(newPassword)
                        .send());

        When("^(User|Manager) updates password to \"([^\"]*)\" for last created user using verification password \"([^\"]*)\"$",
                (String requester, String newPassword, String authenticatedUserPassword) -> changePasswordByUserRequest
                        .withVerificationPassword(authenticatedUserPassword)
                        .withUserId(lastCreatedUser.getUserId())
                        .withNewPasswordForUser(newPassword)
                        .send());

        When("^Admin updates password to null for last created user$",
                () -> changePasswordByUserRequest
                        .withVerificationPassword("pa$$w0rd")
                        .withUserId(lastCreatedUser.getUserId())
                        .withNewPasswordForUser(null)
                        .send());

        And("^Admin updates password to \"([^\"]*)\" for last created user with wrong admin password$", (String newPassword) -> changePasswordByUserRequest
                .withVerificationPassword("wrongAdminPassword")
                .withUserId(lastCreatedUser.getUserId())
                .withNewPasswordForUser(newPassword)
                .send());
    }
}
