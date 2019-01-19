package com.sample.qa.common;

/**
 * Created by kasunalwis on 12/27/18.
 */
public class Constant {
    public static final String TEST_ENV = TAFProperties.getCommonProperty("test.env");

    // --------------> Sample Service
    public static final String SAMPLE_SERVICE_API_HOST = TAFProperties.getEnvProperty("sampleService.api.host");
    public static final String SAMPLE_SERVICE_API_BASE_PATH = TAFProperties.getEnvProperty("sampleService.api.basepath");
    public static final int SAMPLE_SERVICE_API_PORT = Integer.parseInt(TAFProperties.getEnvProperty("sampleService.api.port"));
}
