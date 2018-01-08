package com.samuleev.server.model;

import lombok.Data;

public @Data
class Document {

    private String value;

    public Document(String value) {
        this.value = value;
    }
}
