package xyz.greatapp.step_definitions.user;

import cucumber.api.java8.En;
import xyz.greatapp.api.client.holders.LastCreatedUser;
import xyz.greatapp.api.client.holders.LastSelectedUser;
import xyz.greatapp.api.client.requests.api.user.UserDeletionRequest;

public class UserDeletion implements En
{
    public UserDeletion(UserDeletionRequest userDeletionRequest,
            LastCreatedUser lastCreatedUser,
            LastSelectedUser lastSelectedUser)
    {
        And("^(User|Manager|Admin) deletes last created user$",
                (String requester) -> userDeletionRequest
                        .withUserId(lastCreatedUser.getUserId())
                        .send());

        And("^(User|Manager|Admin) deletes last created user with wrong id$",
                (String requester) -> userDeletionRequest
                        .withUserId("wrongId")
                        .send());

        And("^(User|Manager|Admin) deletes last selected user$",
                (String requester) -> userDeletionRequest
                        .withUserId(lastSelectedUser.getUserId())
                        .send());

    }
}
