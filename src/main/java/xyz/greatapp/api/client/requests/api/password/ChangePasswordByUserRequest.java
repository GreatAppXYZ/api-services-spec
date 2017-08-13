package xyz.greatapp.api.client.requests.api.password;

import static org.springframework.http.HttpMethod.PUT;

import org.json.JSONObject;
import org.springframework.http.HttpMethod;
import xyz.greatapp.api.client.api_client.ApiUser;
import xyz.greatapp.api.client.api_client.CsrfToken;
import xyz.greatapp.api.client.requests.ResultListener;
import xyz.greatapp.api.client.requests.api.ApiRequest;

public class ChangePasswordByUserRequest extends ApiRequest
{
    private String verificationPassword = "pa$$w0rd";
    private String userId = "user1@greatapp.xyz";
    private String newPasswordForUser = "password1";

    public ChangePasswordByUserRequest(ApiUser apiUser, ResultListener resultListener, CsrfToken csrfToken) {
        super(apiUser, resultListener, csrfToken);
    }

    @Override
    protected String getRequestBody() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("verification_password", verificationPassword);
        jsonObject.put("user_id", userId);
        jsonObject.put("new_password_for_user", newPasswordForUser);
        return jsonObject.toString();
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return PUT;
    }

    @Override
    protected String getUrlPath() {
        return "password/updateForUser";
    }

    public ChangePasswordByUserRequest withVerificationPassword(String verificationPassword)
    {
        this.verificationPassword = verificationPassword;
        return this;
    }

    public ChangePasswordByUserRequest withUserId(String userId)
    {
        this.userId = userId;
        return this;
    }

    public ChangePasswordByUserRequest withNewPasswordForUser(String newPasswordForUser)
    {
        this.newPasswordForUser = newPasswordForUser;
        return this;
    }
}
