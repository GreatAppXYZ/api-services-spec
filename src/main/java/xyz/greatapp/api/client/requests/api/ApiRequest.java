package xyz.greatapp.api.client.requests.api;

import static java.util.Objects.nonNull;
import static xyz.greatapp.api.client.util.ParserUtil.toServiceResult;

import org.springframework.http.HttpMethod;
import xyz.greatapp.api.client.api_client.HttpClient;
import xyz.greatapp.api.client.api_client.ApiUser;
import xyz.greatapp.api.client.api_client.CsrfToken;
import xyz.greatapp.api.client.api_client.HttpRequestData;
import xyz.greatapp.api.client.requests.ResultListener;
import xyz.greatapp.libs.service.ServiceResult;

public abstract class ApiRequest
{

    private final static HttpClient apiClient = new HttpClient();
    private final ApiUser apiUser;
    private final ResultListener resultListener;
    private final CsrfToken csrfToken;

    public ApiRequest(ApiUser apiUser, ResultListener resultListener, CsrfToken csrfToken)
    {
        this.apiUser = apiUser;
        this.resultListener = resultListener;
        this.csrfToken = csrfToken;
    }

    public ServiceResult send()
    {
        final HttpRequestData httpRequestData = getHttpRequestData();
        final String restResponse = apiClient.getRestResponse(httpRequestData);
        ServiceResult serviceResult = toServiceResult(restResponse);
        if (nonNull(resultListener))
        {
            resultListener.set(serviceResult);
        }
        return serviceResult;
    }

    protected HttpRequestData getHttpRequestData()
    {
        HttpRequestData httpRequestData = new HttpRequestData()
                .setHttpMethod(getHttpMethod())
                .setApiUser(apiUser)
                .setBody(getRequestBody())
                .setUrlPath(getUrlPath())
                .setContentType("application/json")
                .setApiUrl("http://test.localhost:9090/");
        if (apiUser != ApiUser.NULL && nonNull(apiUser.getAccessToken()) && apiUser.getAccessToken().length() > 0)
        {
            httpRequestData.setAuthorization("Bearer " + httpRequestData.getApiUser().getAccessToken());
        }
        if (csrfToken != CsrfToken.NULL)
        {
            httpRequestData.setCsrfToken(csrfToken.getToken());
        }
        return httpRequestData;
    }

    public ApiUser getApiUser()
    {
        return apiUser;
    }

    protected abstract String getRequestBody();

    protected abstract HttpMethod getHttpMethod();

    protected abstract String getUrlPath();
}
