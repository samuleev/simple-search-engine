package com.samuleev.server.controller.adapter.remote;

import com.samuleev.remote.model.RemoteKey;
import com.samuleev.server.model.DocumentKey;

public final class RemoteKeyConverter {
    private RemoteKeyConverter() {
    }

    public static RemoteKey convert(DocumentKey documentKey){
        return new RemoteKey(documentKey.getValue());
    }
}
