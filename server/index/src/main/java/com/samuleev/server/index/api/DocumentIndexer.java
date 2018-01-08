package com.samuleev.server.index.api;

public interface DocumentIndexer {

    void addToIndex(String key, String document);

}
