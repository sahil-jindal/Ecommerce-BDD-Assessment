package testrunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ListenerTest implements ITestListener {

    ExtentSparkReporter html;
    ExtentReports extent;
    ExtentTest test;

    public void onStart(ITestContext context) {
        LocalDateTime now = LocalDateTime.now();
        String strDateTime = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss").format(now);
        String testName = context.getName();
        html = new ExtentSparkReporter(testName + "_" + strDateTime + ".html");
        extent = new ExtentReports();
        extent.attachReporter(html);
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }

    public void onTestStart(ITestResult result) {
        String name = result.getName();
        test = extent.createTest(name);
    }

    public void onTestSuccess(ITestResult result) {
        String test = result.getName();
        this.test.pass(test + " has passed");
    }

    public void onTestFailure(ITestResult result) {
        String test = result.getName();
        this.test.fail(test + " has failed");
    }
}