package xyz.greatapp.api.client.api_client;

public class ApiUser {
    public static ApiUser NULL = new ApiUser();
    private String accessToken;

    public void withAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken()
    {
        return accessToken;
    }
}
