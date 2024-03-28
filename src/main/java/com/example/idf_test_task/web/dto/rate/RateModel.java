package com.example.idf_test_task.web.dto.rate;



import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RateModel {
    @JsonProperty
    private Meta meta;

    @JsonProperty
    private List<RateValue> values;

    @JsonProperty
    private String status;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<RateValue> getValues() {
        return values;
    }

    public void setValues(List<RateValue> values) {
        this.values = values;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RateModel{" +
                "meta=" + meta +
                ", values=" + values +
                ", status='" + status + '\'' +
                '}';
    }

}
