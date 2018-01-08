package com.samuleev.client.commands;

import com.samuleev.client.consumer.api.RemoteDocumentSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SearchCommand implements Command {

    @Autowired
    private RemoteDocumentSearcher remoteDocumentSearcher;

    @Override
    public void execute(String commandDetails) {
        if (commandDetails.isEmpty()) {
            System.out.println("Error: empty search string!");
            return;
        }
        Set<String> keys = remoteDocumentSearcher.search(commandDetails);
        if (keys != null) {
            printKeys(keys);
        }
    }

    private void printKeys(Set<String> keys) {
        for (String key : keys) {
            System.out.print(key + " ");
        }
        System.out.println();
    }
}
