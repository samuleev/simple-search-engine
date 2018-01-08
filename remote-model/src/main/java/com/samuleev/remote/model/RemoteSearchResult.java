package com.samuleev.remote.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data
class RemoteSearchResult {

    private Set<RemoteKey> keys;

    public RemoteSearchResult() {
    }

    public RemoteSearchResult(Set<RemoteKey> keys) {
        this.keys = keys;
    }
}
