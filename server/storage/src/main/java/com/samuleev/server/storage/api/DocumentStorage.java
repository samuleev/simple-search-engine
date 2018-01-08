package com.samuleev.server.storage.api;

import com.samuleev.server.model.Document;
import com.samuleev.server.model.DocumentKey;

public interface DocumentStorage {

    void put(DocumentKey key, Document document);

    Document get(DocumentKey key);

}
