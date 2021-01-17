package com.mars.rover.util;

/**
 * String utility methods
 */
public class StringUtil {

    /**
     * Below method tests emptiness of given {@link String}
     * @param string
     * @return <code>true</code> if string is not empty , else returns <code>false</code>
     */
    public static boolean isEmpty(String string) {
        return (null == string || string.trim().isEmpty());
    }
}
