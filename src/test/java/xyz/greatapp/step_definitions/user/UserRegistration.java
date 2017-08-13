package xyz.greatapp.step_definitions.user;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import cucumber.api.java8.StepdefBody;
import xyz.greatapp.api.client.requests.api.registration.UserRegistrationRequest;

public class UserRegistration implements En
{

    public UserRegistration(UserRegistrationRequest userRegistrationRequest)
    {
        Given("^User provides correct registration information$", () -> {
        });

        Given("^User provides empty email$", () -> userRegistrationRequest.withEmail(""));

        Given("^User provides empty password$", () -> userRegistrationRequest.withPassword(""));

        Given("^User provides less than 6 characters password$", () -> userRegistrationRequest.withPassword("short"));

        Given("^User provides null email$", () -> userRegistrationRequest.withEmail(null));

        Given("^User provides null password$", () -> userRegistrationRequest.withPassword(null));

        Given("^User sends registration request with \"([^\"]*)\" as username and \"([^\"]*)\" as password$",
                (String username, String password) -> {
                    userRegistrationRequest.withEmail(username).withPassword(password);
                    userRegistrationRequest.send();
                });

        When("^User sends registration request$",
                userRegistrationRequest::send);

        Given("^User sends registration request with username \"([^\"]*)\"$",
                (String username) -> userRegistrationRequest.withEmail(username).send());
    }
}
