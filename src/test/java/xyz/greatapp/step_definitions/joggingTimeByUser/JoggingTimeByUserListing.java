
package xyz.greatapp.step_definitions.joggingTimeByUser;

import static java.lang.Integer.parseInt;

import cucumber.api.java8.En;
import xyz.greatapp.api.client.requests.api.joggingTimeByUser.JoggingTimeByUserListingRequest;
import xyz.greatapp.api.client.holders.LastCreatedUser;

public class JoggingTimeByUserListing implements En
{
    public JoggingTimeByUserListing(JoggingTimeByUserListingRequest joggingTimeByUserListingRequest,
            LastCreatedUser lastCreatedUser)
    {
        When("^(User|Manager|Admin) sends request to get jogging times by user from \"([^\"]*)\" to \"([^\"]*)\" for last created user$",
                (String requester, String from, String to) -> {

                    joggingTimeByUserListingRequest.withUserId(lastCreatedUser.getUserId());

                    String[] fromParts = from.split("-");
                    String[] toParts = to.split("-");

                    joggingTimeByUserListingRequest
                            .withFromDay(parseInt(fromParts[0]))
                            .withFromMonth(parseInt(fromParts[1]))
                            .withFromYear(parseInt(fromParts[2]));
                    joggingTimeByUserListingRequest
                            .withToDay(parseInt(toParts[0]))
                            .withToMonth(parseInt(toParts[1]))
                            .withToYear(parseInt(toParts[2]));

                    joggingTimeByUserListingRequest.send();
        });
    }
}
