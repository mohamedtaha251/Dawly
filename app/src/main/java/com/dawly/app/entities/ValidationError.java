package com.dawly.app.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Anas on 12/9/2017.
 */

public class ValidationError {

    @JsonProperty("property_name")
    private String propertyName;
    @JsonProperty("messages")
    private List<String> messageList;

    public String getPropertyName() {
        return propertyName;
    }

    public List<String> getMessageList() {
        return messageList;
    }
}
