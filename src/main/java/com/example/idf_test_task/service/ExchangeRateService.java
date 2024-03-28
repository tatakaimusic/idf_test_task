package com.example.idf_test_task.service;

import com.example.idf_test_task.config.RedisSchema;
import com.example.idf_test_task.model.Rate;
import com.example.idf_test_task.web.dto.rate.RateModel;
import com.example.idf_test_task.service.props.RatesProperties;
import com.example.idf_test_task.web.dto.rate.RateValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.*;

@Service
public class ExchangeRateService {

    private final ExecutorService executorService;
    private final RatesProperties ratesProperties;
    private final ObjectMapper objectMapper;
    private final JedisPool jedisPool;

    @Autowired
    public ExchangeRateService(
            ExecutorService executorService,
            RatesProperties ratesProperties,
            ObjectMapper objectMapper,
            JedisPool jedisPool
    ) {
        this.executorService = executorService;
        this.ratesProperties = ratesProperties;
        this.objectMapper = objectMapper;
        this.jedisPool = jedisPool;
    }

    public void saveRatesParallel() {
        List<String> rates = ratesProperties.getValues();
        for (String rate : rates) {
            executorService.submit(() -> saveRate(rate));
        }
    }

    public Rate getRate(String rate) {
        try (Jedis jedis = jedisPool.getResource()) {
            String key = RedisSchema.RatesKeys(
                    rate
                            + ":"
                            + LocalDate.now()
            );
            return new Rate(
                    rate,
                    new BigDecimal(
                            jedis.hget(
                                    key,
                                    "rate"
                            )
                    ),
                    LocalDate.now()
            );
        }
    }

    private BigDecimal saveRate(String rate) throws JsonProcessingException {
        String url =
                "https://api.twelvedata.com/time_series?symbol=" + rate
                        + "&interval=1day"
                        + "&apikey=" + ratesProperties.getTwelveApiKey();
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        RateModel rateModel = objectMapper.readValue(result, RateModel.class);
        BigDecimal close = null;

        for (RateValue rateValue : rateModel.getValues()) {
            if (rateValue.getClose() != null) {
                close = rateValue.getClose();
                break;
            }
        }

        try (Jedis jedis = jedisPool.getResource()) {
            String key = RedisSchema.RatesKeys(
                    rate
                            + ":"
                            + LocalDate.now()
            );
            jedis.hset(
                    key,
                    "rate",
                    String.valueOf(close)
            );
        }

        return close;
    }

}
