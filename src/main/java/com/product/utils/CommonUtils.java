package com.product.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CommonUtils {

    public static String getParameter(String paramName) {
        return System.getProperty(paramName);

    }

}
