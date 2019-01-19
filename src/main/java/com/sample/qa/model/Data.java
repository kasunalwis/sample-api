package com.sample.qa.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by kasunalwis on 12/28/18.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data {
    private int id;
    private String firstName;
    private String lastName;
    private String avatar;
}
