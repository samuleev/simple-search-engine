package com.samuleev.server.service;

import com.samuleev.server.model.Document;
import com.samuleev.server.model.DocumentKey;
import com.samuleev.server.model.DocumentSearchCriteria;
import com.samuleev.server.model.DocumentSearchResult;

public interface SearchEngineFacade {

    void save(DocumentKey key, Document document);

    Document load(DocumentKey key);

    DocumentSearchResult search(DocumentSearchCriteria searchString);

}
