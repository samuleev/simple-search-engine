package com.samuleev.client.consumer.api;

import java.util.Set;

public interface RemoteDocumentSearcher {

    Set<String> search(String searchString);

}
