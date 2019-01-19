package com.sample.qa.common;

/**
 * Created by kasunalwis on 12/27/18.
 */
public enum APIComponents {
    SAMPLE_SERVICE("Sample reqres");

    private String value;

    private APIComponents(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
