package xyz.greatapp.api.client.requests.api.transactions;

import org.springframework.http.HttpMethod;
import xyz.greatapp.api.client.api_client.ApiUser;
import xyz.greatapp.api.client.api_client.CsrfToken;
import xyz.greatapp.api.client.requests.ResultListener;
import xyz.greatapp.api.client.requests.api.ApiRequest;

import static org.springframework.http.HttpMethod.GET;

public class RollbackTransactionRequest extends ApiRequest
{

    public RollbackTransactionRequest(ApiUser apiUser, ResultListener resultListener, CsrfToken csrfToken)
    {
        super(apiUser, resultListener, csrfToken);
    }

    @Override
    protected String getRequestBody() {
        return null;
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return GET;
    }

    @Override
    protected String getUrlPath() {
        return "acceptance_test/transaction/rollback";
    }
}
