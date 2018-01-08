package com.samuleev.client.commands;

import com.samuleev.client.FirstTokenSeparateUtil;
import com.samuleev.client.consumer.api.RemoteDocumentStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PutCommand implements Command {

    @Autowired
    private RemoteDocumentStorage remoteDocumentStorage;

    @Override
    public void execute(String commandDetails) {
        String documentKey = FirstTokenSeparateUtil.getFirstToken(commandDetails);
        if (documentKey.isEmpty()) {
            System.out.println("Error: empty document key!");
            return;
        }

        String document = FirstTokenSeparateUtil.getRest(commandDetails);
        if (document.isEmpty()) {
            System.out.println("Error: empty document body!");
            return;
        }

        String key = remoteDocumentStorage.put(documentKey, document);

        if (documentKey.equals(key)) {
            System.out.println("Document " + key + " successfully saved.");
        }
    }
}
