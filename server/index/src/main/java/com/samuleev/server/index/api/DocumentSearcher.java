package com.samuleev.server.index.api;

import java.util.Set;

public interface DocumentSearcher {

    Set<String> search(String searchString);

}
