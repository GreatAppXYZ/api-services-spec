package xyz.greatapp.api.client.requests.api.password;

import static org.springframework.http.HttpMethod.PUT;

import org.json.JSONObject;
import org.springframework.http.HttpMethod;
import xyz.greatapp.api.client.api_client.ApiUser;
import xyz.greatapp.api.client.api_client.CsrfToken;
import xyz.greatapp.api.client.requests.ResultListener;
import xyz.greatapp.api.client.requests.api.ApiRequest;

public class ChangePasswordRequest extends ApiRequest
{
    private String currentPassword = "password1";
    private String newPassword = "password2";

    public ChangePasswordRequest(ApiUser apiUser, ResultListener resultListener, CsrfToken csrfToken) {
        super(apiUser, resultListener, csrfToken);
    }

    @Override
    protected String getRequestBody() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("current_password", currentPassword);
        jsonObject.put("new_password", newPassword);
        return jsonObject.toString();
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return PUT;
    }

    @Override
    protected String getUrlPath() {
        return "password/update";
    }

    public ChangePasswordRequest withCurrentPassword(String currentPassword)
    {
        this.currentPassword = currentPassword;
        return this;
    }

    public ChangePasswordRequest withNewPassword(String newPassword)
    {
        this.newPassword = newPassword;
        return this;
    }
}
