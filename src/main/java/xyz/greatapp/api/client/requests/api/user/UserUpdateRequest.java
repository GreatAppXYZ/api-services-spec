package xyz.greatapp.api.client.requests.api.user;

import static org.springframework.http.HttpMethod.PUT;

import org.json.JSONObject;
import org.springframework.http.HttpMethod;
import xyz.greatapp.api.client.api_client.ApiUser;
import xyz.greatapp.api.client.api_client.CsrfToken;
import xyz.greatapp.api.client.requests.ResultListener;
import xyz.greatapp.api.client.requests.api.ApiRequest;

public class UserUpdateRequest extends ApiRequest
{
    private String userId = "";
    private String name = "user1";
    private String email = "user1@greatapp.xyz";
    private String role = "USER";

    public UserUpdateRequest(ApiUser apiUser, ResultListener resultListener, CsrfToken csrfToken) {
        super(apiUser, resultListener, csrfToken);
    }

    @Override
    protected String getRequestBody() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user_id", userId);
        jsonObject.put("name", name);
        jsonObject.put("email", email);
        jsonObject.put("role", role);
        return jsonObject.toString();
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return PUT;
    }

    @Override
    protected String getUrlPath() {
        return "user/update";
    }

    public UserUpdateRequest withName(String name)
    {
        this.name = name;
        return this;
    }

    public UserUpdateRequest withEmail(String email)
    {
        this.email = email;
        return this;
    }

    public UserUpdateRequest withRole(String role)
    {
        this.role = role;
        return this;
    }

    public UserUpdateRequest withUserId(String userId)
    {
        this.userId = userId;
        return this;
    }
}
