package xyz.greatapp.step_definitions.hooks;

import xyz.greatapp.api.client.requests.api.transactions.BeginTransactionRequest;
import xyz.greatapp.api.client.requests.api.transactions.RollbackTransactionRequest;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ApiTransactionHook
{
    private final BeginTransactionRequest beginTransactionRequest;
    private final RollbackTransactionRequest rollbackTransactionRequest;

    public ApiTransactionHook(BeginTransactionRequest beginTransactionRequest,
                              RollbackTransactionRequest rollbackTransactionRequest) {

        this.beginTransactionRequest = beginTransactionRequest;
        this.rollbackTransactionRequest = rollbackTransactionRequest;
    }

    @Before(order = 2)
    public final void baseSetUp() {
        beginTransactionRequest.send();
    }

    @After
    public final void baseTearDown() {
        rollbackTransactionRequest.send();
    }
}
