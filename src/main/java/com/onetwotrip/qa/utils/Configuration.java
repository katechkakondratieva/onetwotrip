package com.onetwotrip.qa.utils;

import java.io.IOException;
import java.util.Properties;

public class Configuration {
    public String host;

    private Configuration() {
        try {
            initConfigProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ConfigurationHolder {
        static final Configuration HOLDER = new Configuration();
    }

    public static Configuration instance() {
        return Configuration.ConfigurationHolder.HOLDER;
    }

    private void initConfigProperties() throws IOException {
        Properties configProperties = new Properties();
        configProperties.load(Configuration.class.getClassLoader().getResourceAsStream("config.properties"));
        host = configProperties.getProperty("host");
    }

}
