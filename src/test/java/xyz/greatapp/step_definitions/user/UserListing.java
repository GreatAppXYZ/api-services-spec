
package xyz.greatapp.step_definitions.user;

import cucumber.api.java8.En;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import xyz.greatapp.api.client.holders.LastSelectedUser;
import xyz.greatapp.api.client.requests.api.user.UserListingRequest;
import xyz.greatapp.libs.service.ServiceResult;

public class UserListing implements En
{
    public UserListing(UserListingRequest userListingRequest,
            LastSelectedUser lastSelectedUser)
    {
        When("^(User|Admin|Manager) sends request to list users$", (String requester) -> userListingRequest.send());

        And("^Admin selects admin user$", () -> {
            ServiceResult serviceResult = userListingRequest.send();
            try
            {
                JSONArray users = new JSONArray(serviceResult.getObject());
                JSONObject user = new JSONObject(users.get(0).toString());
                lastSelectedUser.withUserId(user.getString("user_id"));
            }
            catch (JSONException e)
            {
                throw new RuntimeException();
            }
        });
    }
}
