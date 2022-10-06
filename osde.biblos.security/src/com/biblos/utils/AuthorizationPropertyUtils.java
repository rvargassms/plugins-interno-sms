package com.biblos.utils;

import com.biblos.loader.AuthorizationPropertiesLoader;
import com.dotmarketing.util.Logger;

import java.util.Properties;

public class AuthorizationPropertyUtils {

    private static String OSDE_PARENT_ROLE;
    private static String VALIDATOR_PARENT_ROLE;
    private static String ADMIN_ROLE;

    public static void getAllPropertiesAuthorization() {
        Properties properties = AuthorizationPropertiesLoader.loadAllProperties();
        try {
            OSDE_PARENT_ROLE = AuthorizationPropertiesLoader.getProperty(properties, "osdeParentRole");
            VALIDATOR_PARENT_ROLE = AuthorizationPropertiesLoader.getProperty(properties, "validatorParentRole");
            ADMIN_ROLE = AuthorizationPropertiesLoader.getProperty(properties, "admin.role");
        } catch (Exception ex) {
            Logger.error(AuthorizationPropertyUtils.class, ex.getMessage());
        }
    }

    public static String getOsdeParentRole() { return OSDE_PARENT_ROLE; }
    public static String getValidatorParentRole() { return VALIDATOR_PARENT_ROLE; }
    public static String getAdminRole() { return ADMIN_ROLE; }
}
