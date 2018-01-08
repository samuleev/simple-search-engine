package com.samuleev.server.index.impl.tokenizer.api;

import java.util.Set;

public interface Tokenizer {

    Set<String> getTokens(String document);

}
