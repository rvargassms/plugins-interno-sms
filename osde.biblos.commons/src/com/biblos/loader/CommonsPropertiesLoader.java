package com.biblos.loader;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public class CommonsPropertiesLoader {

    private static final String PROPERTIES_PATH = "biblos-dotcms-commons.properties";

    public static Properties loadAllProperties() {
        try {
            return PropertiesLoaderUtils.loadAllProperties(PROPERTIES_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getProperty(Properties properties, String name) throws IOException {
        return properties.getProperty(name);
    }
}
