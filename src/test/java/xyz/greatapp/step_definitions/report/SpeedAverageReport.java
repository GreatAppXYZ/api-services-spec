
package xyz.greatapp.step_definitions.report;

import cucumber.api.java8.En;
import xyz.greatapp.api.client.requests.api.report.SpeedAverageReportRequest;

public class SpeedAverageReport implements En
{
    public SpeedAverageReport(SpeedAverageReportRequest speedAverageReportRequest)
    {
        When("^User sends request to get speed average report$", speedAverageReportRequest::send);
    }
}
