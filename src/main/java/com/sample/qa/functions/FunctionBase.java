package com.sample.qa.functions;

import com.sample.qa.common.APIAttributes;
import com.sample.qa.common.APIComponents;
import com.sample.qa.common.ContentTypes;
import com.sample.qa.utils.APIRestUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kasunalwis on 12/27/18.
 */
public class FunctionBase {
    protected static APIRestUtils apiRestUtils = new APIRestUtils(APIComponents.SAMPLE_SERVICE);

    protected static Map<String, String> getCommonRequestHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put(APIAttributes.CONTENT_TYPE, ContentTypes.APPLICATION_JSON);
        headers.put(APIAttributes.ACCEPT, ContentTypes.APPLICATION_JSON);
        return headers;
    }
}
