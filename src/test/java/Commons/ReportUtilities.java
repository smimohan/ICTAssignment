package Commons;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ReportUtilities extends Driver implements ITestListener {


    public static ExtentReports reports;
    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context) {

        String path = System.getProperty("user.dir");
        reports = new ExtentReports();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("report//report.html");
        try {
            reports.setSystemInfo("Machine Name", InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        reports.attachReporter(extentSparkReporter);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest = reports.createTest(result.getName());
        extentTest.log(Status.PASS, result.getName());
        try {
            String ss = Driver.takeScreenshot(driver, result.getName());
            extentTest.pass("Passed test case: ", MediaEntityBuilder.createScreenCaptureFromPath(ss).build());
           // extentTest.addScreenCaptureFromPath(Driver.takeScreenshot());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest = reports.createTest(result.getName());
        extentTest.log(Status.FAIL, result.getName());
        try {
            String ss = Driver.takeScreenshot(driver, result.getName());
            extentTest.fail("Failed test case: ", MediaEntityBuilder.createScreenCaptureFromPath(ss).build());
            extentTest.addScreenCaptureFromPath(Driver.takeScreenshot(driver,result.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest = reports.createTest(result.getName());
        extentTest.log(Status.SKIP, result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush();
    }
}