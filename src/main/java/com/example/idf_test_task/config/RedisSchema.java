package com.example.idf_test_task.config;

public class RedisSchema {

    public static String RatesKeys(String rate) {
        return KeyHelper.getKey("rates") + ":" + rate;
    }

}
