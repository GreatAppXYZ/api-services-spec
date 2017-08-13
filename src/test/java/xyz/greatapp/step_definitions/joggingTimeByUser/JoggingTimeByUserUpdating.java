
package xyz.greatapp.step_definitions.joggingTimeByUser;

import static java.lang.Integer.valueOf;

import cucumber.api.java8.En;
import xyz.greatapp.api.client.holders.LastCreatedJoggingTime;
import xyz.greatapp.api.client.requests.api.joggingTimeByUser.JoggingTimeByUserUpdatingRequest;
import xyz.greatapp.api.client.holders.LastCreatedUser;

public class JoggingTimeByUserUpdating implements En
{
    public JoggingTimeByUserUpdating(
            JoggingTimeByUserUpdatingRequest joggingTimeByUserUpdatingRequest,
            LastCreatedJoggingTime lastCreatedJoggingTime,
            LastCreatedUser lastCreatedUser)
    {
        When("^(User|Manager|Admin) updates last created jogging time by user with date \"([^\"]*)\"$", (String requester, String date) ->
        {
            String[] dateParts = date.split("-");
            joggingTimeByUserUpdatingRequest
                    .withUserId(lastCreatedUser.getUserId())
                    .withJoggingTimeId(lastCreatedJoggingTime.getJoggingTimeId())
                    .withDay(valueOf(dateParts[0]))
                    .withMonth(valueOf(dateParts[1]))
                    .withYear(valueOf(dateParts[2]))
                    .send();
        });

        When("^(User|Admin) updates last created jogging time by user with distance (\\d+) and time (\\d+)$",
                (String requester, Integer distance, Integer time) ->
                        joggingTimeByUserUpdatingRequest
                                .withUserId(lastCreatedUser.getUserId())
                                .withJoggingTimeId(lastCreatedJoggingTime.getJoggingTimeId())
                                .withDistance(distance)
                                .withTime(time)
                                .send());

        When("^(User|Admin) updates last created jogging time by user with null day", (String requester) ->
                joggingTimeByUserUpdatingRequest
                        .withUserId(lastCreatedUser.getUserId())
                        .withJoggingTimeId(lastCreatedJoggingTime.getJoggingTimeId())
                        .withDay(null)
                        .send());

        When("^(User|Admin) updates last created jogging time by user with null month", (String requester) ->
                joggingTimeByUserUpdatingRequest
                        .withUserId(lastCreatedUser.getUserId())
                        .withJoggingTimeId(lastCreatedJoggingTime.getJoggingTimeId())
                        .withMonth(null)
                        .send());

        When("^(User|Admin) updates last created jogging time by user with null year", (String requester) ->
                joggingTimeByUserUpdatingRequest
                        .withUserId(lastCreatedUser.getUserId())
                        .withJoggingTimeId(lastCreatedJoggingTime.getJoggingTimeId())
                        .withYear(null)
                        .send());

        When("^(User|Admin) updates jogging time by user with wrong jogging time id$", (String requester) -> {
            joggingTimeByUserUpdatingRequest
                    .withUserId(lastCreatedUser.getUserId())
                    .withJoggingTimeId("wrong id");
            joggingTimeByUserUpdatingRequest.send();
        });

        When("^(User|Admin) updates jogging time by user with wrong user id$", (String requester) -> {
            joggingTimeByUserUpdatingRequest
                    .withUserId("wrong id")
                    .withJoggingTimeId(lastCreatedJoggingTime.getJoggingTimeId());
            joggingTimeByUserUpdatingRequest.send();
        });
    }
}
