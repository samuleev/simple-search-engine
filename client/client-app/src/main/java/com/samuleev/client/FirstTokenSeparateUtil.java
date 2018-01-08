package com.samuleev.client;

public final class FirstTokenSeparateUtil {

    public static final String EMPTY_TOKEN = "";

    private static final String TOKEN_DELIMITER = " ";

    private FirstTokenSeparateUtil() {
    }

    public static String getFirstToken(String input) {
        String split[] = split(input);
        return split.length > 0 ? split[0] : EMPTY_TOKEN;
    }

    public static String getRest(String input) {
        String split[] = split(input);
        return split.length > 1 ? split[1] : EMPTY_TOKEN;
    }

    private static String[] split(String input) {
        return input.split(TOKEN_DELIMITER, 2);
    }
}
