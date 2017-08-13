package xyz.greatapp.api.client.requests.api.joggingTimeByUser;

import static org.springframework.http.HttpMethod.PUT;

import org.json.JSONObject;
import org.springframework.http.HttpMethod;
import xyz.greatapp.api.client.api_client.ApiUser;
import xyz.greatapp.api.client.api_client.CsrfToken;
import xyz.greatapp.api.client.requests.ResultListener;
import xyz.greatapp.api.client.requests.api.ApiRequest;

public class JoggingTimeByUserUpdatingRequest extends ApiRequest
{
    private String userId;
    private String joggingTimeId = "";
    private Integer day = 1;
    private Integer month = 8;
    private Integer year = 2017;
    private Integer distance = 1000;
    private Integer time = 60;

    public JoggingTimeByUserUpdatingRequest(ApiUser apiUser, ResultListener resultListener, CsrfToken csrfToken)
    {
        super(apiUser, resultListener, csrfToken);
    }

    @Override
    protected String getRequestBody()
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user_id", userId);
        jsonObject.put("jogging_times_id", joggingTimeId);
        jsonObject.put("day", day);
        jsonObject.put("month", month);
        jsonObject.put("year", year);
        jsonObject.put("distance", distance);
        jsonObject.put("time", time);
        return jsonObject.toString();
    }

    @Override
    protected HttpMethod getHttpMethod()
    {
        return PUT;
    }

    @Override
    protected String getUrlPath()
    {
        return "joggingTime/updateForUser";
    }

    public JoggingTimeByUserUpdatingRequest withDay(Integer day)
    {
        this.day = day;
        return this;
    }

    public JoggingTimeByUserUpdatingRequest withMonth(Integer month)
    {
        this.month = month;
        return this;
    }

    public JoggingTimeByUserUpdatingRequest withYear(Integer year)
    {
        this.year = year;
        return this;
    }

    public JoggingTimeByUserUpdatingRequest withDistance(Integer distance)
    {
        this.distance = distance;
        return this;
    }

    public JoggingTimeByUserUpdatingRequest withTime(Integer time)
    {
        this.time = time;
        return this;
    }

    public JoggingTimeByUserUpdatingRequest withJoggingTimeId(String joggingTimeId)
    {
        this.joggingTimeId = joggingTimeId;
        return this;
    }

    public JoggingTimeByUserUpdatingRequest withUserId(String userId)
    {
        this.userId = userId;
        return this;
    }
}
