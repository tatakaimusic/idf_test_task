package com.example.idf_test_task.service.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "rates")
public class RatesProperties {

    private String twelveApiKey;
    private List<String> values;

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public String getTwelveApiKey() {
        return twelveApiKey;
    }

    public void setTwelveApiKey(String twelveApiKey) {
        this.twelveApiKey = twelveApiKey;
    }

}
