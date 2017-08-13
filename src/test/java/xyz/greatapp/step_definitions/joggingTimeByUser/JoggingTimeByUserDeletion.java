
package xyz.greatapp.step_definitions.joggingTimeByUser;

import cucumber.api.java8.En;
import xyz.greatapp.api.client.holders.LastCreatedJoggingTime;
import xyz.greatapp.api.client.requests.api.joggingTimeByUser.JoggingTimeByUserDeletionRequest;
import xyz.greatapp.api.client.holders.LastCreatedUser;

public class JoggingTimeByUserDeletion implements En
{
    public JoggingTimeByUserDeletion(
            JoggingTimeByUserDeletionRequest joggingTimeByUserDeletionRequest,
            LastCreatedUser lastCreatedUser, LastCreatedJoggingTime lastCreatedJoggingTime)
    {
        When("^(User|Manager|Admin) deletes last created jogging time for last created user$",
                (String requester) -> joggingTimeByUserDeletionRequest
                        .withUserId(lastCreatedUser.getUserId())
                        .withJoggingTimesId(lastCreatedJoggingTime.getJoggingTimeId())
                        .send());
    }
}
