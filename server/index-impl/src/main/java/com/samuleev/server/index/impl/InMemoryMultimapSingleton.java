package com.samuleev.server.index.impl;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;

public final class InMemoryMultimapSingleton {

    private static SetMultimap<String, String> setMultimap = null;

    private InMemoryMultimapSingleton() {}

    public static synchronized SetMultimap<String, String> getInstance() {
        if (setMultimap == null) {
            setMultimap = createSetMultimap();
        }
        return setMultimap;
    }

    private static SetMultimap<String, String> createSetMultimap() {
        return Multimaps.synchronizedSetMultimap(HashMultimap.create());
    }
}
