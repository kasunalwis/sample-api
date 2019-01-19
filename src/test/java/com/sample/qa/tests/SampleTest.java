package com.sample.qa.tests;

import com.jayway.restassured.response.Response;
import com.sample.qa.functions.SampleServiceAPIs;
import com.sample.qa.model.User;
import com.sample.qa.utils.APIListener;
import com.sample.qa.utils.JacksonUtils;
import com.sample.qa.utils.TestBase;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by kasunalwis on 12/27/18.
 */
@Listeners(APIListener.class)
public class SampleTest extends TestBase{

    @Test(description = "")
    public void testSingleFeature() {
        Response response = SampleServiceAPIs.getSingleUser("2");
        User singleUserResponse = (User) JacksonUtils.getObject(response.asString(), User.class);
        softAssert.assertEquals(response.getStatusCode(), 200, "Invalid API status code return");
        assert singleUserResponse != null : "user response object is null";
        softAssert.assertEquals(singleUserResponse.getData().getId(),2,"User ID is invalid");
        softAssert.assertAll();
    }
}
