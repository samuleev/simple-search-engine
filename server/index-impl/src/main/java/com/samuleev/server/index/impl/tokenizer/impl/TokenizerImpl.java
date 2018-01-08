package com.samuleev.server.index.impl.tokenizer.impl;

import com.samuleev.server.index.impl.tokenizer.api.Tokenizer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TokenizerImpl implements Tokenizer {
    @Override
    public Set<String> getTokens(String document) {
        return new HashSet<>(Arrays.asList(document.split("\\s")));
    }
}
