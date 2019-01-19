package com.sample.qa.common;

/**
 * Created by kasunalwis on 12/27/18.
 */
public enum HTTPRequestMethods {
    GET("GET"),
    PUT("PUT"),
    POST("POST"),
    DELETE("DELETE"),
    PATCH("PATCH");

    private String value;

    private HTTPRequestMethods(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
