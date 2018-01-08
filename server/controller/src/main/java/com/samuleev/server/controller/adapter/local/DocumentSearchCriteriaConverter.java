package com.samuleev.server.controller.adapter.local;

import com.samuleev.remote.model.RemoteSearchCriteria;
import com.samuleev.server.model.DocumentSearchCriteria;

public final class DocumentSearchCriteriaConverter {

    private DocumentSearchCriteriaConverter() {
    }
    
    public static DocumentSearchCriteria convert(RemoteSearchCriteria remoteSearchCriteria){
        return new DocumentSearchCriteria(remoteSearchCriteria.getValue());
    }
}
