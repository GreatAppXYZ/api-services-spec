package xyz.greatapp.api.client.requests.api.joggingTimeByUser;

import static org.springframework.http.HttpMethod.POST;

import org.json.JSONObject;
import org.springframework.http.HttpMethod;
import xyz.greatapp.api.client.api_client.ApiUser;
import xyz.greatapp.api.client.api_client.CsrfToken;
import xyz.greatapp.api.client.requests.ResultListener;
import xyz.greatapp.api.client.requests.api.ApiRequest;

public class JoggingTimeByUserRegistrationRequest extends ApiRequest
{
    private String userId = "";
    private Integer day = 1;
    private Integer month = 8;
    private Integer year = 2017;
    private Integer distance = 1000;
    private Integer time = 60;

    public JoggingTimeByUserRegistrationRequest(ApiUser apiUser, ResultListener resultListener, CsrfToken csrfToken) {
        super(apiUser, resultListener, csrfToken);
    }

    @Override
    protected String getRequestBody() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user_id", userId);
        jsonObject.put("day", day);
        jsonObject.put("month", month);
        jsonObject.put("year", year);
        jsonObject.put("distance", distance);
        jsonObject.put("time", time);
        return jsonObject.toString();
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return POST;
    }

    @Override
    protected String getUrlPath() {
        return "joggingTime/createForUser";
    }

    public JoggingTimeByUserRegistrationRequest withDay(Integer day)
    {
        this.day = day;
        return this;
    }

    public JoggingTimeByUserRegistrationRequest withMonth(Integer month)
    {
        this.month = month;
        return this;
    }

    public JoggingTimeByUserRegistrationRequest withYear(Integer year)
    {
        this.year = year;
        return this;
    }

    public JoggingTimeByUserRegistrationRequest withDistance(Integer distance)
    {
        this.distance = distance;
        return this;
    }

    public JoggingTimeByUserRegistrationRequest withTime(Integer time)
    {
        this.time = time;
        return this;
    }

    public JoggingTimeByUserRegistrationRequest withUserId(String userId)
    {
        this.userId = userId;
        return this;
    }
}
