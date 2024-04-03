package com.example.idf_test_task.service;

import com.example.idf_test_task.model.Rate;

public interface ExchangeRateService {

    void saveRatesParallel();

    Rate getRate(String rate);

}
