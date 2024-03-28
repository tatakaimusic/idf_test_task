package com.example.idf_test_task.config;

import java.util.Objects;

public class KeyHelper {

    private final static String defaultPrefix = "app";

    private static String prefix = null;

    public static void setPrefix(String prefix) {
        KeyHelper.prefix = prefix;
    }

    public static String getKey(String key) {
        return getPrefix() + ":" + key;
    }

    public static String getPrefix() {
        return Objects.requireNonNullElse(prefix, defaultPrefix);
    }

}
