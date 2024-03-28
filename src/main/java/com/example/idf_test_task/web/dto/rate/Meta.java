package com.example.idf_test_task.web.dto.rate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta {
    @JsonProperty
    private String symbol;

    @JsonProperty
    private String interval;

    @JsonProperty
    private String currency_base;

    @JsonProperty
    private String currency_quote;

    @JsonProperty
    private String type;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getCurrency_base() {
        return currency_base;
    }

    public void setCurrency_base(String currency_base) {
        this.currency_base = currency_base;
    }

    public String getCurrency_quote() {
        return currency_quote;
    }

    public void setCurrency_quote(String currency_quote) {
        this.currency_quote = currency_quote;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "symbol='" + symbol + '\'' +
                ", interval='" + interval + '\'' +
                ", currency_base='" + currency_base + '\'' +
                ", currency_quote='" + currency_quote + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
