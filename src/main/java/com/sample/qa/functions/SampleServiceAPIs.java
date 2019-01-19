package com.sample.qa.functions;

import com.sample.qa.common.APIResourcePaths;
import com.sample.qa.common.HTTPRequestMethods;
import com.sample.qa.utils.LoggerUtil;
import com.jayway.restassured.response.Response;

/**
 * Created by kasunalwis on 12/27/18.
 */
public class SampleServiceAPIs extends  FunctionBase{

    public static Response getSingleUser(String userID){
        LoggerUtil.logINFO("REQUEST -> SampleServiceAPIs.getSingleUser");
        return apiRestUtils.send(getCommonRequestHeaders(), "", APIResourcePaths.SINGLE_USER + "/" + userID, HTTPRequestMethods.GET, null);
    }
}
