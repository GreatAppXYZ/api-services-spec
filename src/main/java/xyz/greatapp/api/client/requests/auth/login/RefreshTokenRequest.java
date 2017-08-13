package xyz.greatapp.api.client.requests.auth.login;

import static org.springframework.http.HttpMethod.POST;

import org.springframework.http.HttpMethod;
import xyz.greatapp.api.client.requests.ResultListener;
import xyz.greatapp.api.client.requests.auth.AuthRequest;

public class RefreshTokenRequest extends AuthRequest
{
    private String refreshToken = "";

    public RefreshTokenRequest(ResultListener resultListener)
    {
        super(resultListener);
    }

    @Override
    protected String getRequestBody()
    {
        return "grant_type=refresh_token&client_id=greatappxyz&refresh_token=" + refreshToken;
    }

    @Override
    protected HttpMethod getHttpMethod()
    {
        return POST;
    }

    @Override
    protected String getUrlPath()
    {
        return "oauth/token";
    }

    public RefreshTokenRequest withRefreshToken(String refreshToken)
    {
        this.refreshToken = refreshToken;
        return this;
    }
}
