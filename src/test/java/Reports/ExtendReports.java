package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;

public class ExtendReports {
    static ExtentReports extent;

    public static ExtentReports extentReportGenerator() {
        String path = System.getProperty("user.dir") + File.separator + "target" + File.separator + "ExtentReport" + File.separator + "report-" + System.currentTimeMillis() + ".html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("htmlReport");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("ReportGenerate", "Successfully");
        return extent;
    }
}
