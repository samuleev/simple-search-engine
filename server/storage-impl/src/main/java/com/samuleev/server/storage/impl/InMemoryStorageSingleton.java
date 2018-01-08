package com.samuleev.server.storage.impl;

import com.samuleev.server.model.Document;
import com.samuleev.server.model.DocumentKey;

import java.util.HashMap;
import java.util.Map;

public class InMemoryStorageSingleton {

    private static Map<DocumentKey, Document> map = null;

    private InMemoryStorageSingleton() {}

    public static synchronized Map<DocumentKey, Document> getInstance() {
        if (map == null) {
            map = new HashMap<>();
        }
        return map;
    }
}
