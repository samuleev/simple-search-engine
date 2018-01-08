package com.samuleev.remote.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data
class RemoteDocument {

    private RemoteKey key;

    private String value;

    public RemoteDocument() {
    }

    public RemoteDocument(RemoteKey key, String value) {
        this.key = key;
        this.value = value;
    }
}
