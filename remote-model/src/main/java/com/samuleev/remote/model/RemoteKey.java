package com.samuleev.remote.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data
class RemoteKey {

    private String value;

    public RemoteKey() {
    }

    public RemoteKey(String value) {
        this.value = value;
    }
}
