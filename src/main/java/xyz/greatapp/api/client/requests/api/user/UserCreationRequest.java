package xyz.greatapp.api.client.requests.api.user;

import static org.springframework.http.HttpMethod.POST;

import org.json.JSONObject;
import org.springframework.http.HttpMethod;
import xyz.greatapp.api.client.api_client.ApiUser;
import xyz.greatapp.api.client.api_client.CsrfToken;
import xyz.greatapp.api.client.requests.ResultListener;
import xyz.greatapp.api.client.requests.api.ApiRequest;

public class UserCreationRequest extends ApiRequest
{
    private String name = "user1";
    private String email = "user1@greatapp.xyz";
    private String role = "USER";
    private String password = "secret";

    public UserCreationRequest(ApiUser apiUser, ResultListener resultListener, CsrfToken csrfToken) {
        super(apiUser, resultListener, csrfToken);
    }

    @Override
    protected String getRequestBody() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("email", email);
        jsonObject.put("role", role);
        jsonObject.put("password", password);
        return jsonObject.toString();
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return POST;
    }

    @Override
    protected String getUrlPath() {
        return "user/create";
    }

    public UserCreationRequest withName(String name)
    {
        this.name = name;
        return this;
    }

    public UserCreationRequest withEmail(String email)
    {
        this.email = email;
        return this;
    }

    public UserCreationRequest withRole(String role)
    {
        this.role = role;
        return this;
    }

    public UserCreationRequest withPassword(String password)
    {
        this.password = password;
        return this;
    }
}
