package com.samuleev.server.storage.impl;

import com.samuleev.server.model.Document;
import com.samuleev.server.model.DocumentKey;
import com.samuleev.server.storage.api.DocumentStorage;
import org.springframework.stereotype.Service;

@Service
public class DocumentStorageImpl implements DocumentStorage {

    @Override
    public void put(DocumentKey key, Document document) {
        InMemoryStorageSingleton.getInstance().put(key, document);
    }

    @Override
    public Document get(DocumentKey key) {
        return InMemoryStorageSingleton.getInstance().get(key);
    }
}
