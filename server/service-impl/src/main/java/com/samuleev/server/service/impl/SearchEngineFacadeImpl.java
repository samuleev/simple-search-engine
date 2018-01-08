package com.samuleev.server.service.impl;

import com.samuleev.server.index.api.DocumentIndexer;
import com.samuleev.server.index.api.DocumentSearcher;
import com.samuleev.server.model.Document;
import com.samuleev.server.model.DocumentKey;
import com.samuleev.server.model.DocumentSearchCriteria;
import com.samuleev.server.model.DocumentSearchResult;
import com.samuleev.server.service.SearchEngineFacade;
import com.samuleev.server.storage.api.DocumentStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SearchEngineFacadeImpl implements SearchEngineFacade {

    @Autowired
    private DocumentIndexer documentIndexer;

    @Autowired
    private DocumentSearcher documentSearcher;

    @Autowired
    private DocumentStorage documentStorage;

    @Override
    public void save(DocumentKey documentKey, Document document) {
        documentIndexer.addToIndex(documentKey.getValue(),
                document.getValue());

        documentStorage.put(documentKey, document);
    }

    @Override
    public Document load(DocumentKey key) {
        return documentStorage.get(key);
    }

    @Override
    public DocumentSearchResult search(DocumentSearchCriteria documentSearchCriteria) {
        Set<String> stringKeys =
                documentSearcher.search(documentSearchCriteria.getSearchString());
        return convert(stringKeys);
    }

    private DocumentSearchResult convert(Set<String> stringKeys) {
        Set<DocumentKey> documentKeys = new HashSet<DocumentKey>();
        for(String stringKey : stringKeys) {
            documentKeys.add(new DocumentKey(stringKey));
        }
        return new DocumentSearchResult(documentKeys);
    }

}
