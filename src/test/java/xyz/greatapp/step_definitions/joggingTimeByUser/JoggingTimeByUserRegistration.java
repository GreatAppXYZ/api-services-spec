
package xyz.greatapp.step_definitions.joggingTimeByUser;

import static java.lang.Integer.valueOf;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

import cucumber.api.java8.En;

import java.util.Calendar;

import xyz.greatapp.api.client.holders.LastCreatedJoggingTime;
import xyz.greatapp.api.client.requests.api.joggingTimeByUser.JoggingTimeByUserRegistrationRequest;
import xyz.greatapp.api.client.holders.LastCreatedUser;
import xyz.greatapp.libs.service.ServiceResult;

public class JoggingTimeByUserRegistration implements En
{
    public JoggingTimeByUserRegistration(
            JoggingTimeByUserRegistrationRequest joggingTimeByUserRegistrationRequest,
            LastCreatedUser lastCreatedUser, LastCreatedJoggingTime lastCreatedJoggingTime)
    {
        Given("^(User|Manager|Admin) provides correct jogging time by user information$", (String requester) -> {
            Calendar cal = Calendar.getInstance();
            joggingTimeByUserRegistrationRequest
                    .withYear(cal.get(YEAR))
                    .withMonth(cal.get(MONTH) + 1)
                    .withDay(cal.get(DAY_OF_MONTH))
                    .withDistance(1000)
                    .withTime(60);
        });

        Given("^Admin provides jogging time by user with date in the past", () -> {
            Calendar cal = Calendar.getInstance();
            cal.add(DAY_OF_MONTH, -2);
            joggingTimeByUserRegistrationRequest
                    .withYear(cal.get(YEAR))
                    .withMonth(cal.get(MONTH) + 1)
                    .withDay(cal.get(DAY_OF_MONTH));
        });

        When("^(User|Manager|Admin) sends create jogging time by user request for last created user$",
                (String requester) -> joggingTimeByUserRegistrationRequest
                        .withUserId(lastCreatedUser.getUserId())
                        .send());

        Given("^Admin provides (\\d+) as day, (\\d+) as month and (\\d+) as year for jogging time registration by user$",
                (Integer day, Integer month, Integer year) -> joggingTimeByUserRegistrationRequest
                        .withDay(day)
                        .withMonth(month)
                        .withYear(year));

        Given("^Admin provides null day for jogging time registration by user$",
                () -> joggingTimeByUserRegistrationRequest
                        .withDay(null));

        Given("^Admin provides null month for jogging time registration by user$",
                () -> joggingTimeByUserRegistrationRequest
                        .withMonth(null));

        Given("^Admin provides null year for jogging time registration by user$",
                () -> joggingTimeByUserRegistrationRequest
                        .withYear(null));

        Given("^Admin provides future date for jogging time by user$", () -> {
            Calendar cal = Calendar.getInstance();
            cal.add(DAY_OF_MONTH, 1);
            joggingTimeByUserRegistrationRequest
                    .withYear(cal.get(YEAR))
                    .withMonth(cal.get(MONTH) + 1)
                    .withDay(cal.get(DAY_OF_MONTH));
        });

        Given("^Admin registers jogging time by user for \"([^\"]*)\" for last created user$", (String date) -> {
            String[] dateParts = date.split("-");
            joggingTimeByUserRegistrationRequest
                    .withUserId(lastCreatedUser.getUserId())
                    .withDay(valueOf(dateParts[0]))
                    .withMonth(valueOf(dateParts[1]))
                    .withYear(valueOf(dateParts[2]));
            ServiceResult serviceResult = joggingTimeByUserRegistrationRequest.send();
            lastCreatedJoggingTime.withJoggingTimeId(serviceResult.getObject());
        });

        When("^(User|Manager|Admin) creates jogging time by user request for last created user with date \"([^\"]*)\"$",
                (String requester, String date) -> {
                    String[] dateParts = date.split("-");
                    ServiceResult serviceResult = joggingTimeByUserRegistrationRequest
                            .withUserId(lastCreatedUser.getUserId())
                            .withDay(valueOf(dateParts[0]))
                            .withMonth(valueOf(dateParts[1]))
                            .withYear(valueOf(dateParts[2]))
                            .withDistance(1000)
                            .withTime(60)
                            .send();
                    lastCreatedJoggingTime.withJoggingTimeId(serviceResult.getObject());
                });

        And("^(User|Manager|Admin) creates jogging time by user request for last created user with distance (\\d+) and time (\\d+)$",
                (String requester, Integer distance, Integer time) -> {
                    ServiceResult serviceResult = joggingTimeByUserRegistrationRequest
                            .withUserId(lastCreatedUser.getUserId())
                            .withDistance(distance)
                            .withTime(time)
                            .send();
                    lastCreatedJoggingTime.withJoggingTimeId(serviceResult.getObject());
                });

        When("^(User|Manager|Admin) creates jogging time by user for last created user",
                (String requester) -> {
                    ServiceResult serviceResult = joggingTimeByUserRegistrationRequest
                            .withUserId(lastCreatedUser.getUserId())
                            .send();
                    lastCreatedJoggingTime.withJoggingTimeId(serviceResult.getObject());
                });
    }
}
