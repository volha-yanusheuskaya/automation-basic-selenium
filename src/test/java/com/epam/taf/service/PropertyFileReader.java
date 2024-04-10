package com.epam.taf.service;

import java.util.ResourceBundle;

public class PropertyFileReader {

    private static final ResourceBundle CSS_SELECTORS_BUNDLE = ResourceBundle.getBundle("css_selectors");

    public static String getCssSelector(String key) {
        return CSS_SELECTORS_BUNDLE.getString(key);
    }
}
