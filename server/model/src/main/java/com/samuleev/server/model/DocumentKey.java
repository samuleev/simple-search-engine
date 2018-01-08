package com.samuleev.server.model;

import lombok.Data;

public @Data
class DocumentKey {

    private String value;

    public DocumentKey(String value) {
        this.value = value;
    }
}
