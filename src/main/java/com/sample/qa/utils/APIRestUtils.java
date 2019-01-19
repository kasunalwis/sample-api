package com.sample.qa.utils;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.config.EncoderConfig;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.sample.qa.common.APIComponents;
import com.sample.qa.common.Constant;
import com.sample.qa.common.HTTPRequestMethods;

import java.util.Map;

/**
 * Created by kasunalwis on 12/27/18.
 */
public class APIRestUtils {
    private String apiHost;
    private String basePath;
    private int port = 0;

    public String getApiHost() {
        return apiHost;
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public APIRestUtils(APIComponents component) {
        switch (component) {
            case SAMPLE_SERVICE:
                init(Constant.SAMPLE_SERVICE_API_HOST, Constant.SAMPLE_SERVICE_API_BASE_PATH, Constant.SAMPLE_SERVICE_API_PORT);
                break;
        }
    }

    public Response send(Map<String, String> headers, String bodyString, String uri, HTTPRequestMethods requestMethod, Map<String, String> queryParameters) {
        logRequestBody(bodyString);
        RequestSpecification requestSpecification = RestAssured.given().spec(getRequestSpec(headers, bodyString, queryParameters));
        Response response = execute(requestMethod, requestSpecification, uri);
        logResponse(response);
        return response;
    }

    private void logRequestBody(String bodyString) {
        if (bodyString != null && !bodyString.isEmpty())
            LoggerUtil.logINFO("\n\nREQUEST_BODY\n" + bodyString + "\n********\n\n");
    }

    private void logResponse(Response response) {
        if (response != null)
            LoggerUtil.logINFO("\n\nRESPONSE\n" + response.asString() + "\n*********\n\n");
    }

    private Response execute(HTTPRequestMethods reqMethod, RequestSpecification requestSpec, String uri) {
        RequestSpecification requestSpecification = RestAssured.given(requestSpec).config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)));

        Response response = null;
        if (reqMethod.equals(HTTPRequestMethods.GET)) {
            response = requestSpecification.expect().when().get(uri);
        }

        if (reqMethod.equals(HTTPRequestMethods.POST)) {
            response = requestSpecification.expect().when().post(uri);
        }

        if (reqMethod.equals(HTTPRequestMethods.PUT)) {
            response = requestSpecification.expect().when().put(uri);
        }

        if (reqMethod.equals(HTTPRequestMethods.DELETE)) {
            response = requestSpecification.expect().when().delete(uri);
        }

        if (reqMethod.equals(HTTPRequestMethods.PATCH)) {
            response = requestSpecification.expect().when().patch(uri);
        }

        return response;
    }

    private RequestSpecification getRequestSpec(Map<String, String> headers, String body, Map<String, ?> queryParameters) {
        RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();

        reqSpecBuilder.setBaseUri(getApiHost());
        reqSpecBuilder.setBasePath(getBasePath());
        reqSpecBuilder.setPort(getPort());

        if (headers != null) {
            reqSpecBuilder.addHeaders(headers);
        }

        if (body != null && body.length() > 0) {
            reqSpecBuilder.setBody(body);
        }

        if (queryParameters != null && !queryParameters.isEmpty())
            reqSpecBuilder.addQueryParameters(queryParameters);

        return reqSpecBuilder.build();
    }

    private void init(String apiHost, String basePath, int port) {
        setApiHost(apiHost);
        setBasePath(basePath);
        setPort(port);
    }
}
