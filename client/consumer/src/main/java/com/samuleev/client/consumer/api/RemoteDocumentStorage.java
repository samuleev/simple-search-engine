package com.samuleev.client.consumer.api;

public interface RemoteDocumentStorage {

    String put(String key, String document);

    String get(String key);

}
