package com.samuleev.client.consumer.impl;

import com.samuleev.client.consumer.api.RemoteDocumentSearcher;
import com.samuleev.remote.model.RemoteKey;
import com.samuleev.remote.model.RemoteSearchCriteria;
import com.samuleev.remote.model.RemoteSearchResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

@Service
public class RemoteDocumentSearcherImpl implements RemoteDocumentSearcher {

    @Override
    public Set<String> search(String searchString) {
        RestTemplate restTemplate = new RestTemplate();
        RemoteSearchResult remoteSearchResult;

        try {
            remoteSearchResult = restTemplate.postForObject(Configuration.BASE_URL + "/search",
                getRemoteSearchCriteria(searchString), RemoteSearchResult.class);
        } catch (RestClientException e) {
            RestExceptionHandler.handle(e);
            return null;
        }

        return convertRemoteSearchResult(remoteSearchResult);
    }

    private RemoteSearchCriteria getRemoteSearchCriteria(String searchString) {
        return new RemoteSearchCriteria(searchString);
    }

    private Set<String> convertRemoteSearchResult(RemoteSearchResult remoteSearchResult) {
        Set<String> stringKeys = new HashSet<String>();
        for (RemoteKey remoteKey : remoteSearchResult.getKeys()) {
            stringKeys.add(remoteKey.getValue());
        }
        return stringKeys;
    }

}
