package xyz.greatapp.api.client.requests.api.user;

import static org.springframework.http.HttpMethod.GET;

import org.springframework.http.HttpMethod;
import xyz.greatapp.api.client.api_client.ApiUser;
import xyz.greatapp.api.client.api_client.CsrfToken;
import xyz.greatapp.api.client.requests.ResultListener;
import xyz.greatapp.api.client.requests.api.ApiRequest;

public class UserListingRequest extends ApiRequest
{
    public UserListingRequest(ApiUser apiUser, ResultListener resultListener, CsrfToken csrfToken)
    {
        super(apiUser, resultListener, csrfToken);
    }

    @Override
    protected String getRequestBody()
    {
        return "";
    }

    @Override
    protected HttpMethod getHttpMethod()
    {
        return GET;
    }

    @Override
    protected String getUrlPath()
    {
        return "user/getAll";
    }
}
