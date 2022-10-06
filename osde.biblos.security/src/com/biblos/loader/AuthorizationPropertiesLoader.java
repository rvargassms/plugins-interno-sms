package com.biblos.loader;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class AuthorizationPropertiesLoader {

    private static final String PROPERTIES_PATH = "biblos-dotcms-authorization.properties";
    private static String ROUTE = "biblos.dotCMS.authorization.";

    public static Properties loadAllProperties() {
        try {
            return PropertiesLoaderUtils.loadAllProperties(PROPERTIES_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getProperty(Properties properties, String name) throws IOException {
        return properties.getProperty(ROUTE + name);
    }
}
