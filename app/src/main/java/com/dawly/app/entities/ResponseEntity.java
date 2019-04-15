package com.dawly.app.entities;

import com.dawly.app.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Anas on 12/9/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseEntity<T> extends BaseEntity {

    @JsonProperty("success")
    private boolean status;
    @JsonProperty("message")
    private  String message;
    @JsonProperty("data")
    private T Data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }



}
