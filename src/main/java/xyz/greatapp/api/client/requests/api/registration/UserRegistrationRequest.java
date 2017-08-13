package xyz.greatapp.api.client.requests.api.registration;

import org.json.JSONObject;
import org.springframework.http.HttpMethod;
import xyz.greatapp.api.client.api_client.ApiUser;
import xyz.greatapp.api.client.api_client.CsrfToken;
import xyz.greatapp.api.client.requests.ResultListener;
import xyz.greatapp.api.client.requests.api.ApiRequest;

import static org.springframework.http.HttpMethod.POST;

public class UserRegistrationRequest extends ApiRequest
{
    private String email = "test@greatapp.xyz";
    private String password = "secret";

    public UserRegistrationRequest(ApiUser apiUser, ResultListener resultListener, CsrfToken csrfToken) {
        super(apiUser, resultListener, csrfToken);
    }

    @Override
    protected String getRequestBody() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", email);
        jsonObject.put("password", password);
        return jsonObject.toString();
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return POST;
    }

    @Override
    protected String getUrlPath() {
        return "registerUser";
    }

    public UserRegistrationRequest withEmail(String phone) {
        this.email = phone;
        return this;
    }

    public UserRegistrationRequest withPassword(String password) {
        this.password = password;
        return this;
    }
}
