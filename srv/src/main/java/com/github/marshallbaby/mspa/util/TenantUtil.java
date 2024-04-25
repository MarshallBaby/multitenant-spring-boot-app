package com.github.marshallbaby.mspa.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TenantUtil {

    public static String createSchemaName(String tenantId) {
        return String.format("tenant_%s", tenantId.replace("-", "_"));
    }

}
