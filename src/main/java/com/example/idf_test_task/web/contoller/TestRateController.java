package com.example.idf_test_task.web.contoller;

import com.example.idf_test_task.model.Rate;
import com.example.idf_test_task.service.impl.ExchangeRateServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class TestRateController {

    private final ExchangeRateServiceImpl exchangeRateService;

    @Autowired
    public TestRateController(ExchangeRateServiceImpl exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @PostMapping("/rates")
    public void saveRates() throws ExecutionException, InterruptedException, JsonProcessingException {
        exchangeRateService.saveRatesParallel();
    }

    @GetMapping("/rates")
    public Rate getRates() {
        return exchangeRateService.getRate("USD/RUB");
    }

}
