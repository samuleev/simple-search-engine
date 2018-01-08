package com.samuleev.server.controller.adapter.local;

import com.samuleev.remote.model.RemoteDocument;
import com.samuleev.remote.model.RemoteKey;
import com.samuleev.server.model.DocumentKey;

public final class DocumentKeyConverter {

    private DocumentKeyConverter() {
    }

    public static DocumentKey convert(RemoteKey remoteKey) {
        return new DocumentKey(remoteKey.getValue());
    }

    public static DocumentKey getConvertedKey(RemoteDocument remoteDocument){
        return new DocumentKey(remoteDocument.getKey().getValue());
    }

}
