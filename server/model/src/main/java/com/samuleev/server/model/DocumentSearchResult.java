package com.samuleev.server.model;

import lombok.Data;

import java.util.Set;

public @Data
class DocumentSearchResult {

    private Set<DocumentKey> keys;

    public DocumentSearchResult(Set<DocumentKey> keys) {
        this.keys = keys;
    }
}
