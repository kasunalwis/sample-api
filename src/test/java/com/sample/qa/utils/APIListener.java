package com.sample.qa.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by kasunalwis on 12/27/18.
 */
public class APIListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LoggerUtil.logINFO("Test PASSED");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LoggerUtil.logINFO("Test FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LoggerUtil.logINFO("Test SKIPPED");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
