package com.sample.qa.common;

import com.sample.qa.utils.LoggerUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by kasunalwis on 12/27/18.
 */
public class TAFProperties {
    private static Properties envProperties = null;
    private static Properties commonProperties = null;

    public static String getEnvProperty(String key) {
        if (envProperties == null)
            loadEnvProperties();

        String p = System.getProperty(key);
        return p != null ? p : envProperties.getProperty(key);
    }

    public static String getCommonProperty(String key) {
        if (commonProperties == null)
            loadCommonProperties();

        String p = System.getProperty(key);
        return p != null ? p : commonProperties.getProperty(key);
    }

    private static void loadEnvProperties() {
        envProperties = new Properties();
        InputStream input;
        try {
            input = TAFProperties.class.getResourceAsStream("/sample_api_" + getCommonProperty("test.env") + "_config.properties");
            envProperties.load(input);
        } catch (IOException e) {
            LoggerUtil.logERROR(e.getMessage(), e);
        }
    }

    private static void loadCommonProperties() {
        commonProperties = new Properties();
        InputStream input;
        try {
            input = TAFProperties.class.getResourceAsStream("/sample_api_common_config.properties");
            commonProperties.load(input);
        } catch (IOException e) {
            LoggerUtil.logERROR(e.getMessage(), e);
        }
    }
}
