package xyz.greatapp.api.client.requests.api.user;

import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.POST;

import org.json.JSONObject;
import org.springframework.http.HttpMethod;
import xyz.greatapp.api.client.api_client.ApiUser;
import xyz.greatapp.api.client.api_client.CsrfToken;
import xyz.greatapp.api.client.requests.ResultListener;
import xyz.greatapp.api.client.requests.api.ApiRequest;

public class UserDeletionRequest extends ApiRequest
{
    private String userId = "";

    public UserDeletionRequest(ApiUser apiUser, ResultListener resultListener, CsrfToken csrfToken) {
        super(apiUser, resultListener, csrfToken);
    }

    @Override
    protected String getRequestBody() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user_id", userId);
        return jsonObject.toString();
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return DELETE;
    }

    @Override
    protected String getUrlPath() {
        return "user/delete";
    }

    public UserDeletionRequest withUserId(String userId)
    {
        this.userId = userId;
        return this;
    }
}
