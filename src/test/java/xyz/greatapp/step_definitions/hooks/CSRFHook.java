package xyz.greatapp.step_definitions.hooks;

import cucumber.api.java.Before;
import xyz.greatapp.api.client.api_client.ApiUser;
import xyz.greatapp.api.client.api_client.CsrfToken;
import xyz.greatapp.api.client.requests.api.csrf.CSRFRequest;
import xyz.greatapp.libs.service.ServiceResult;

public class CSRFHook
{
    private final CsrfToken csrfToken;

    public CSRFHook(CsrfToken csrfToken) {

        this.csrfToken = csrfToken;
    }

    @Before(order = 1)
    public final void getCsrfToken() {
        CSRFRequest csrfRequest = new CSRFRequest(ApiUser.NULL, null, CsrfToken.NULL);
        ServiceResult serviceResult = csrfRequest.send();
        csrfToken.withToken(serviceResult.getObject());
    }

}
