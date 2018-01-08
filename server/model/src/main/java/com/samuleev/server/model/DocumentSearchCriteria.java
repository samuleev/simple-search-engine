package com.samuleev.server.model;

import lombok.Data;

public @Data
class DocumentSearchCriteria {

    private String searchString;

    public DocumentSearchCriteria(String searchString) {
        this.searchString = searchString;
    }
}
