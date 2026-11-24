package com.learningplaywright.salesforce.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {
    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input != null) {
                PROPERTIES.load(input);
            }
        } catch (IOException exception) {
            throw new ExceptionInInitializerError(exception);
        }
    }

    private ConfigReader() {
    }

    public static String get(String key) {
        String environmentValue = System.getenv(key);
        if (environmentValue != null && !environmentValue.isBlank()) {
            return environmentValue;
        }

        String systemValue = System.getProperty(key);
        if (systemValue != null && !systemValue.isBlank()) {
            return systemValue;
        }

        return PROPERTIES.getProperty(key, "");
    }

    public static String getRequired(String key) {
        String value = get(key);
        if (value.isBlank()) {
            throw new IllegalStateException("Required configuration is missing: " + key);
        }
        return value;
    }
}
