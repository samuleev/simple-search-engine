package com.samuleev.server.index.impl;

import com.samuleev.server.index.api.DocumentSearcher;
import com.samuleev.server.index.impl.tokenizer.api.Tokenizer;
import com.samuleev.server.index.impl.tokenizer.impl.TokenizerImpl;
import org.springframework.stereotype.Service;

import java.util.*;

@Service()
public class DocumentSearcherImpl implements DocumentSearcher {

    private Tokenizer tokenizer = new TokenizerImpl();

    @Override
    public Set<String> search(String searchString) {
        Set<String> tokens = tokenizer.getTokens(searchString);

        List<Set<String>> keySets = getFilterKeySets(tokens);
        if (keySets.isEmpty()) {
            return Collections.EMPTY_SET;
        }

        if (keySets.size() == 1) {
            return keySets.get(0);
        }

        sortByKeySetSize(keySets);

        return findKeysPresentInAllKeysets(keySets);
    }

    private void sortByKeySetSize(List<Set<String>> keySets) {
        Collections.sort(keySets, (o1, o2) -> new Integer(o1.size()).compareTo(o2.size()));
    }

    private Set<String> findKeysPresentInAllKeysets(List<Set<String>> keySets) {
        Set<String> filteredKeys = new HashSet<>();
        Set<String> smallestKeySet = keySets.get(0);
        List<Set<String>> subList = keySets.subList(1, keySets.size());

        for (String keyFromSmallestKeySet : smallestKeySet) {
            if (isKeyPresentInAllKeysets(keyFromSmallestKeySet, subList)) {
                filteredKeys.add(keyFromSmallestKeySet);
            }
        }
        return filteredKeys;
    }

    private boolean isKeyPresentInAllKeysets(String key, List<Set<String>> keySets) {
        for (Set<String> keySet : keySets) {
            if (!keySet.contains(key)) {
                return false;
            }
        }
        return true;
    }

    private List<Set<String>> getFilterKeySets(Set<String> tokens){
        List<Set<String>> keySets = new ArrayList<>();
        for (String token : tokens) {
            Set<String> keySet = InMemoryMultimapSingleton.getInstance().get(token);

            //If one of the tokens is not present in any document.
            if (keySet.isEmpty()) {
                return Collections.EMPTY_LIST;
            }
            keySets.add(keySet);
        }
        return keySets;
    }


}
