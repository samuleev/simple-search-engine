package com.samuleev.server.controller.adapter.remote;

import com.samuleev.remote.model.RemoteDocument;
import com.samuleev.remote.model.RemoteKey;
import com.samuleev.server.model.Document;
import com.samuleev.server.model.DocumentKey;

public final class RemoteDocumentConverter {

    private RemoteDocumentConverter() {
    }

    public static RemoteDocument convert(DocumentKey documentKey, Document document) {
        RemoteKey remoteKey = RemoteKeyConverter.convert(documentKey);
        return new RemoteDocument(remoteKey, document.getValue());
    }

}
