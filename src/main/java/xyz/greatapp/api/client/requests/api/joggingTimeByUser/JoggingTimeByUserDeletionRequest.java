package xyz.greatapp.api.client.requests.api.joggingTimeByUser;

import static org.springframework.http.HttpMethod.DELETE;

import org.json.JSONObject;
import org.springframework.http.HttpMethod;
import xyz.greatapp.api.client.api_client.ApiUser;
import xyz.greatapp.api.client.api_client.CsrfToken;
import xyz.greatapp.api.client.requests.ResultListener;
import xyz.greatapp.api.client.requests.api.ApiRequest;

public class JoggingTimeByUserDeletionRequest extends ApiRequest
{
    private String userId;
    private String joggingTimesId;

    public JoggingTimeByUserDeletionRequest(ApiUser apiUser, ResultListener resultListener, CsrfToken csrfToken)
    {
        super(apiUser, resultListener, csrfToken);
    }

    @Override
    protected String getRequestBody()
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user_id", userId);
        jsonObject.put("jogging_times_id", joggingTimesId);
        return jsonObject.toString();
    }

    @Override
    protected HttpMethod getHttpMethod()
    {
        return DELETE;
    }

    @Override
    protected String getUrlPath()
    {
        return "joggingTime/deleteForUser";
    }

    public JoggingTimeByUserDeletionRequest withUserId(String userId)
    {
        this.userId = userId;
        return this;
    }

    public JoggingTimeByUserDeletionRequest withJoggingTimesId(String joggingTimesId)
    {
        this.joggingTimesId = joggingTimesId;
        return this;
    }
}
