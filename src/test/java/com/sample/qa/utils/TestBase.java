package com.sample.qa.utils;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;

/**
 * Created by kasunalwis on 12/27/18.
 */
public class TestBase {

    private APIListener apiListener;
    protected SoftAssert softAssert;

    @BeforeClass(alwaysRun = true)
    public void initClass() {
        apiListener = new APIListener();
    }

    @BeforeMethod(alwaysRun = true)
    public void initMethod(Method method) {
        LoggerUtil.logINFO("Running test - " + method.getName());
        this.softAssert = new SoftAssert();
    }
}
