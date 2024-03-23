package com.epam.taf.service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("env"));

    private TestDataReader() {
    }

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}
