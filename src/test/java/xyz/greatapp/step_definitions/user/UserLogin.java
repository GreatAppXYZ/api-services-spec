package xyz.greatapp.step_definitions.user;

import cucumber.api.java8.En;
import xyz.greatapp.api.client.api_client.ApiUser;
import xyz.greatapp.api.client.requests.auth.login.GetTokenRequest;
import xyz.greatapp.libs.service.ServiceResult;

public class UserLogin implements En
{
    public UserLogin(GetTokenRequest userLoginRequest, ApiUser apiUser)
    {
        Given("^User provides \"([^\"]*)\" as username and \"([^\"]*)\" as password$",
                (String email, String password) -> userLoginRequest
                        .withUsername(email)
                        .withPassword(password));

        When("^User sends login request$", () -> {
            ServiceResult serviceResult = userLoginRequest.send();
            apiUser.withAccessToken(serviceResult.getObject());
        });

        Given("^User provides null username and \"([^\"]*)\" as password$",
                (String password) -> userLoginRequest
                        .withUsername(null)
                        .withPassword(password));

        Given("^User provides \"([^\"]*)\" username and null password$",
                (String username) -> userLoginRequest
                        .withUsername(username)
                        .withPassword(null));

        Given("^Admin user sends login request$",
                () -> {
                    ServiceResult serviceResult = userLoginRequest
                            .withUsername("admin@greatapp.xyz")
                            .withPassword("pa$$w0rd")
                            .send();
                    apiUser.withAccessToken(serviceResult.getObject());
                });

        And("^(User|Manager) sends login request with email \"([^\"]*)\"$",
                (String requester, String email) -> {
                    ServiceResult serviceResult = userLoginRequest
                            .withUsername(email)
                            .withPassword("secret")
                            .send();
                    apiUser.withAccessToken(serviceResult.getObject());
                });

        And("^(User|Manager|Admin) sends login request with email \"([^\"]*)\" and password \"([^\"]*)\"$",
                (String requester, String email, String password) -> {
                    ServiceResult serviceResult = userLoginRequest
                            .withUsername(email)
                            .withPassword(password)
                            .send();
                    apiUser.withAccessToken(serviceResult.getObject());
                });
    }
}
