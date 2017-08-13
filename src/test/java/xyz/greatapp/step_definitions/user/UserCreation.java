package xyz.greatapp.step_definitions.user;

import cucumber.api.java8.En;
import xyz.greatapp.api.client.holders.LastCreatedUser;
import xyz.greatapp.api.client.requests.api.user.UserCreationRequest;
import xyz.greatapp.libs.service.ServiceResult;

public class UserCreation implements En
{

    public UserCreation(UserCreationRequest userCreationRequest, LastCreatedUser lastCreatedUser)
    {
        Given("^Admin provides correct user creation information$",
                () -> userCreationRequest
                        .withName("user1")
                        .withEmail("user1@greatapp.xyz")
                        .withRole("USER")
                        .withPassword("password1"));

        When("^(User|Manager|Admin) sends user creation request$", (String requester) -> userCreationRequest.send());

        When("^(User|Manager) provides correct user creation information$",
                (String requester) -> userCreationRequest
                        .withName("user1")
                        .withEmail("user1@greatapp.xyz")
                        .withRole("USER")
                        .withPassword("secret"));

        When("^Admin creates (USER|MANAGER) with email \"([^\"]*)\"$",
                (String role, String email) -> {
                    ServiceResult serviceResult = userCreationRequest
                            .withName("user")
                            .withEmail(email)
                            .withRole(role)
                            .send();
                    lastCreatedUser.withUserId(serviceResult.getObject());
                });

        When("^Admin creates (USER|MANAGER|ADMIN) with email \"([^\"]*)\" and password \"([^\"]*)\"$",
                (String role, String email, String password) -> {
                    ServiceResult serviceResult = userCreationRequest
                            .withName("user")
                            .withEmail(email)
                            .withRole(role)
                            .withPassword(password)
                            .send();
                    lastCreatedUser.withUserId(serviceResult.getObject());
                });

        When("^Admin creates (USER|MANAGER)$",
                (String role) -> {
                    ServiceResult serviceResult = userCreationRequest
                            .withRole(role)
                            .send();
                    lastCreatedUser.withUserId(serviceResult.getObject());
                });

        And("^Admin provides empty email for user creation$",
                () -> userCreationRequest
                        .withEmail(""));

        And("^Admin provides empty password for user creation$",
                () -> userCreationRequest
                        .withPassword(""));

        And("^Admin provides null password for user creation$",
                () -> userCreationRequest
                        .withPassword(null));

        And("^Admin provides password \"([^\"]*)\" for user creation$",
                userCreationRequest::withPassword);

        And("^Admin provides empty role for user creation$",
                () -> userCreationRequest
                        .withRole(""));

        And("^Admin provides \"([^\"]*)\" as role for user creation$",
                userCreationRequest::withRole);

        Given("^(Manager|Admin) creates user with email \"([^\"]*)\"$", (String requester, String email) -> {
            ServiceResult serviceResult = userCreationRequest
                    .withName("user1")
                    .withEmail(email)
                    .withRole("USER")
                    .send();
            lastCreatedUser.withUserId(serviceResult.getObject());
        });

        Given("^(Manager|Admin) creates user$", (String requester) -> {
            ServiceResult serviceResult = userCreationRequest
                    .send();
            lastCreatedUser.withUserId(serviceResult.getObject());
        });
    }
}
