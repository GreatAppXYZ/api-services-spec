package xyz.greatapp.api.client.requests.api.joggingTimeByUser;

import static org.springframework.http.HttpMethod.POST;

import org.json.JSONObject;
import org.springframework.http.HttpMethod;
import xyz.greatapp.api.client.api_client.ApiUser;
import xyz.greatapp.api.client.api_client.CsrfToken;
import xyz.greatapp.api.client.requests.ResultListener;
import xyz.greatapp.api.client.requests.api.ApiRequest;

public class JoggingTimeByUserListingRequest extends ApiRequest
{
    private String userId = "";

    private Integer fromDay = 1;
    private Integer fromMonth = 8;
    private Integer fromYear = 2017;

    private Integer toDay = 7;
    private Integer toMonth = 8;
    private Integer toYear = 2017;

    public JoggingTimeByUserListingRequest(ApiUser apiUser, ResultListener resultListener, CsrfToken csrfToken) {
        super(apiUser, resultListener, csrfToken);
    }

    @Override
    protected String getRequestBody() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user_id", userId);
        jsonObject.put("from", createFromToObject(fromDay, fromMonth, fromYear));
        jsonObject.put("to", createFromToObject(toDay, toMonth, toYear));
        return jsonObject.toString();
    }

    private JSONObject createFromToObject(Integer fromDay, Integer fromMonth, Integer fromYear)
    {
        JSONObject from = new JSONObject();
        from.put("month", fromMonth);
        from.put("day", fromDay);
        from.put("year", fromYear);
        return from;
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return POST;
    }

    @Override
    protected String getUrlPath() {
        return "joggingTime/getByUser";
    }

    public JoggingTimeByUserListingRequest withFromDay(Integer fromDay)
    {
        this.fromDay = fromDay;
        return this;
    }

    public JoggingTimeByUserListingRequest withFromMonth(Integer fromMonth)
    {
        this.fromMonth = fromMonth;
        return this;
    }

    public JoggingTimeByUserListingRequest withFromYear(Integer fromYear)
    {
        this.fromYear = fromYear;
        return this;
    }

    public JoggingTimeByUserListingRequest withToDay(Integer toDay)
    {
        this.toDay = toDay;
        return this;
    }

    public JoggingTimeByUserListingRequest withToMonth(Integer toMonth)
    {
        this.toMonth = toMonth;
        return this;
    }

    public JoggingTimeByUserListingRequest withToYear(Integer toYear)
    {
        this.toYear = toYear;
        return this;
    }

    public JoggingTimeByUserListingRequest withUserId(String userId)
    {
        this.userId = userId;
        return this;
    }
}
