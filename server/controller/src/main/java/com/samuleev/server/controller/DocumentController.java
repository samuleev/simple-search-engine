package com.samuleev.server.controller;

import com.samuleev.remote.model.RemoteDocument;
import com.samuleev.remote.model.RemoteKey;
import com.samuleev.server.controller.adapter.local.DocumentConverter;
import com.samuleev.server.controller.adapter.local.DocumentKeyConverter;
import com.samuleev.server.controller.adapter.remote.RemoteDocumentConverter;
import com.samuleev.server.controller.adapter.remote.RemoteKeyConverter;
import com.samuleev.server.model.Document;
import com.samuleev.server.model.DocumentKey;
import com.samuleev.server.service.SearchEngineFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/documents")
public class DocumentController {

    @Autowired
    private SearchEngineFacade searchEngineFacade;

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    public RemoteDocument getDocument(@PathVariable("key") String remoteKeyAsString) throws NotFoundException {
        DocumentKey documentKey = new DocumentKey(remoteKeyAsString);
        Document document = searchEngineFacade.load(documentKey);
        if (document == null) {
            throw new NotFoundException();
        }
        return RemoteDocumentConverter.convert(documentKey, document);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public RemoteKey postDocument(@RequestBody RemoteDocument remoteDocument) {
        DocumentKey documentKey = DocumentKeyConverter.getConvertedKey(remoteDocument);
        Document document = DocumentConverter.convert(remoteDocument);
        searchEngineFacade.save(documentKey, document);
        return RemoteKeyConverter.convert(documentKey);
    }
}