package com.samuleev.server.index.impl;

import com.samuleev.server.index.api.DocumentIndexer;
import com.samuleev.server.index.impl.tokenizer.api.Tokenizer;
import com.samuleev.server.index.impl.tokenizer.impl.TokenizerImpl;
import org.springframework.stereotype.Service;

@Service
public class DocumentIndexerImpl implements DocumentIndexer {

    private Tokenizer tokenizer = new TokenizerImpl();

    @Override
    public void addToIndex(String documentKey, String document) {
        for (String token : tokenizer.getTokens(document)) {
            InMemoryMultimapSingleton.getInstance().put(token, documentKey);
        }
    }
}
