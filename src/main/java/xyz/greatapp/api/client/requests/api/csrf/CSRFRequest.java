package xyz.greatapp.api.client.requests.api.csrf;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.HEAD;

import org.springframework.http.HttpMethod;
import xyz.greatapp.api.client.api_client.ApiUser;
import xyz.greatapp.api.client.api_client.CsrfToken;
import xyz.greatapp.api.client.api_client.HttpClient;
import xyz.greatapp.api.client.api_client.HttpRequestData;
import xyz.greatapp.api.client.requests.ResultListener;
import xyz.greatapp.api.client.requests.api.ApiRequest;
import xyz.greatapp.libs.service.ServiceResult;

public class CSRFRequest extends ApiRequest
{
    private final static HttpClient httpClient = new HttpClient();

    public CSRFRequest(ApiUser apiUser, ResultListener resultListener, CsrfToken csrfToken)
    {
        super(apiUser, resultListener, csrfToken);
    }

    @Override
    protected String getRequestBody()
    {
        return null;
    }

    @Override
    protected HttpMethod getHttpMethod()
    {
        return HEAD;
    }

    @Override
    protected String getUrlPath()
    {
        return "";
    }
}
