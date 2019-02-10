package com.dawly.app.entities;

import com.dawly.app.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anas on 12/9/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseEntity<T> extends BaseEntity {

    @JsonProperty("Status")
    private
    int status;
    @JsonProperty("Errors")
    private
    List<String> errorList;
    @JsonProperty("Data")
    private T Data;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getErrorList() {
        if (errorList!= null)
            return errorList;
        else
            return  new ArrayList<>();
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }



}
