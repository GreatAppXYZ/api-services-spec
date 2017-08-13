package xyz.greatapp.step_definitions.user;

import cucumber.api.java8.En;
import xyz.greatapp.api.client.holders.LastCreatedUser;
import xyz.greatapp.api.client.requests.api.user.UserUpdateRequest;

public class UserUpdating implements En
{
    public UserUpdating(UserUpdateRequest userUpdateRequest, LastCreatedUser lastCreatedUser)
    {
        Given("^(User|Manager|Admin) updates last created user and sets email to \"([^\"]*)\"$",
                (String requester, String email) -> userUpdateRequest
                        .withUserId(lastCreatedUser.getUserId())
                        .withEmail(email)
                        .send());

        Given("^(Manager|Admin) updates last created user and sets role to \"([^\"]*)\"$",
                (String requester, String role) -> userUpdateRequest
                        .withUserId(lastCreatedUser.getUserId())
                        .withRole(role)
                        .send());

        When("^(Manager|Admin) sends user update request$", (String requester) -> userUpdateRequest.send());
    }
}
