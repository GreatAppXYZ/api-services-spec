package xyz.greatapp.api.client.requests.api.report;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

import org.json.JSONObject;
import org.springframework.http.HttpMethod;
import xyz.greatapp.api.client.api_client.ApiUser;
import xyz.greatapp.api.client.api_client.CsrfToken;
import xyz.greatapp.api.client.requests.ResultListener;
import xyz.greatapp.api.client.requests.api.ApiRequest;

public class SpeedAverageReportRequest extends ApiRequest
{

    public SpeedAverageReportRequest(ApiUser apiUser, ResultListener resultListener, CsrfToken csrfToken)
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
        return "joggingTime/report/perWeek";
    }
}
