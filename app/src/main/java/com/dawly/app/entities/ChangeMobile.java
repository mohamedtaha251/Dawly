package com.dawly.app.entities;

import com.dawly.app.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "Status",
        "Data",
        "Errors"
})
public class ChangeMobile extends BaseEntity {
//    @JsonProperty("Status")
//    private Integer status;
//    @JsonProperty("Data")
//    private String  data;
//    @JsonProperty("Errors")
//    private Object errors;
//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//
//    public Integer getStatus() {
//        return status;
//    }
//
//    public void setStatus(Integer status) {
//        this.status = status;
//    }
//
//    public String getData() {
//        return data;
//    }
//
//
//    public void setData(String data) {
//        this.data = data;
//    }
//
//    public Object getErrors() {
//        return errors;
//    }
//
//    public void setErrors(Object errors) {
//        this.errors = errors;
//    }





}
