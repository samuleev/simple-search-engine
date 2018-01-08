package com.samuleev.server.controller.adapter.remote;

import com.samuleev.remote.model.RemoteKey;
import com.samuleev.remote.model.RemoteSearchResult;
import com.samuleev.server.model.DocumentKey;
import com.samuleev.server.model.DocumentSearchResult;

import java.util.HashSet;
import java.util.Set;

public final class RemoteSearchResultConverter {

    private RemoteSearchResultConverter() {
    }

    public static RemoteSearchResult convert(DocumentSearchResult documentSearchResult) {
        Set<RemoteKey> remoteKeys = new HashSet<>();
        for (DocumentKey documentKey : documentSearchResult.getKeys()) {
            remoteKeys.add(RemoteKeyConverter.convert(documentKey));
        }

        return new RemoteSearchResult(remoteKeys);
    }
}
