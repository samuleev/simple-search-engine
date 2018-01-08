package com.samuleev.client.consumer.impl;

import com.samuleev.client.consumer.api.RemoteDocumentStorage;
import com.samuleev.remote.model.RemoteDocument;
import com.samuleev.remote.model.RemoteKey;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class RemoteDocumentStorageImpl implements RemoteDocumentStorage {

    @Override
    public String put(String key, String document) {
        RestTemplate restTemplate = new RestTemplate();

        RemoteDocument remoteDocument = new RemoteDocument(new RemoteKey(key), document);

        RemoteKey remoteKey;

        try {
            remoteKey = restTemplate.postForObject(Configuration.BASE_URL + "/documents",
                remoteDocument, RemoteKey.class);
        } catch (RestClientException e) {
            RestExceptionHandler.handle(e);
            return null;
        }

        return remoteKey.getValue();
    }

    @Override
    public String get(String key) {
        RestTemplate restTemplate = new RestTemplate();
        RemoteDocument remoteDocument;

        try {
            remoteDocument = restTemplate.getForObject(Configuration.BASE_URL + "/documents/{key}",
                    RemoteDocument.class, key);
        } catch (RestClientException e) {
            RestExceptionHandler.handle(e);
            return null;
        }

        return remoteDocument.getValue();
    }

}
