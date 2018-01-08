package com.samuleev.client.consumer.impl;

import org.springframework.web.client.RestClientException;

public final class RestExceptionHandler {

    private static final String ERROR_PREFIX = "Connection error: ";

    private RestExceptionHandler() {
    }

    public static void handle(RestClientException e) {
        if (e.getCause() != null) {
            System.out.println(ERROR_PREFIX + e.getCause());
        } else {
            System.out.println(ERROR_PREFIX + e.getMessage());
        }
    }
}
