package com.samuleev.remote.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data
class RemoteSearchCriteria {

    private String value;

    public RemoteSearchCriteria() {
    }

    public RemoteSearchCriteria(String value) {
        this.value = value;
    }
}
