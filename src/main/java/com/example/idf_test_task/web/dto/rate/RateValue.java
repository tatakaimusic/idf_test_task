package com.example.idf_test_task.web.dto.rate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class RateValue {
    @JsonProperty
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date datetime;

    @JsonProperty
    private BigDecimal open;

    @JsonProperty
    private BigDecimal high;

    @JsonProperty
    private BigDecimal low;

    @JsonProperty
    private BigDecimal close;

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    @Override
    public String toString() {
        return "RateValue{" +
                "datetime=" + datetime +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                '}';
    }

}
