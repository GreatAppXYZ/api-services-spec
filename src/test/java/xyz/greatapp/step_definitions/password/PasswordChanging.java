package xyz.greatapp.step_definitions.password;

import cucumber.api.java8.En;
import xyz.greatapp.api.client.requests.api.password.ChangePasswordRequest;

public class PasswordChanging implements En
{
    public PasswordChanging(ChangePasswordRequest changePasswordRequest)
    {
        When("^User sends password change request with current password \"([^\"]*)\" and new password \"([^\"]*)\"$",
                (String currentPassword, String newPassword) -> changePasswordRequest
                        .withCurrentPassword(currentPassword)
                        .withNewPassword(newPassword)
                        .send());

        When("^User sends password change request with current password \"([^\"]*)\" and null new password$",
                (String currentPassword) -> changePasswordRequest
                        .withCurrentPassword(currentPassword)
                        .withNewPassword(null)
                        .send());
    }
}
