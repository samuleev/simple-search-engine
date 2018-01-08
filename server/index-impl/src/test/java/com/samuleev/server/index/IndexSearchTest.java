package com.samuleev.server.index;


import com.samuleev.server.index.api.DocumentIndexer;
import com.samuleev.server.index.api.DocumentSearcher;
import com.samuleev.server.index.impl.DocumentIndexerImpl;
import com.samuleev.server.index.impl.DocumentSearcherImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
public class IndexSearchTest {

    @Autowired
    private DocumentIndexer documentIndexer;
    @Autowired
    private DocumentSearcher documentSearcher;

    @Before
    public void setUp() {
        for (Map.Entry<String, String> mapEntry : getKeyToDocumentMap().entrySet()) {
            documentIndexer.addToIndex(mapEntry.getKey(), mapEntry.getValue());
        }
    }

    @Test
    public void SingleTokenPositiveSearchTest() {
        assertEquals(getAsSet("1 2 3 4 5"), documentSearcher.search("a"));
        assertEquals(getAsSet("2 3 4 5 6"), documentSearcher.search("b"));
        assertEquals(getAsSet("3 4 5 6 7"), documentSearcher.search("c"));
    }

    @Test
    public void MultipleTokenPositiveSearchTest() {
        assertEquals(getAsSet("2 3 4 5"), documentSearcher.search("a b"));
        assertEquals(getAsSet("3 4 5 6"), documentSearcher.search("b c"));
        assertEquals(getAsSet("4 5 6 7"), documentSearcher.search("c d"));
    }

    @Test
    public void NegativeSearchTest() {
        assertTrue(documentSearcher.search("ab").isEmpty());
        assertTrue(documentSearcher.search("bc").isEmpty());
        assertTrue(documentSearcher.search("cd").isEmpty());
    }

    private Set getAsSet(String keysAsString) {
        return new HashSet<>(Arrays.asList(keysAsString.split("\\s")));
    }

    private Map<String, String> getKeyToDocumentMap() {
        Map<String, String> map = new HashMap<>();
        map.put("0", "");
        map.put("1", "a");
        map.put("2", "a b");
        map.put("3", "a b c");
        map.put("4", "a b c d");

        map.put("5", "d c b a");
        map.put("6", "d c b");
        map.put("7", "d c");
        map.put("8", "d");

        return map;
    }

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
        @Bean
        public DocumentIndexer documentIndexer() {
            return new DocumentIndexerImpl();
        }

        @Bean
        public DocumentSearcher documentSearcher() {
            return new DocumentSearcherImpl();
        }
    }

}
