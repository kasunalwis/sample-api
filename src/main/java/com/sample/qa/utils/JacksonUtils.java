package com.sample.qa.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by kasunalwis on 12/27/18.
 */
public class JacksonUtils {
    public static Object getObject(String response, Class c) {
        try {
            return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(response, c);
        } catch (IOException e) {
            LoggerUtil.logERROR(e.getMessage(), e);
        }
        return null;
    }
}
