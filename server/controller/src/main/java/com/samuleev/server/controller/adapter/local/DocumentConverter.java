package com.samuleev.server.controller.adapter.local;

import com.samuleev.remote.model.RemoteDocument;
import com.samuleev.server.model.Document;

public final class DocumentConverter {

    private DocumentConverter() {
    }

    public static Document convert(RemoteDocument remoteDocument) {
        return new Document(remoteDocument.getValue());
    }
}
