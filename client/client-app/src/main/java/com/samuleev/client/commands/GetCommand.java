package com.samuleev.client.commands;

import com.samuleev.client.consumer.api.RemoteDocumentStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetCommand implements Command {

    @Autowired
    private RemoteDocumentStorage remoteDocumentStorage;

    @Override
    public void execute(String commandDetails) {
        if (commandDetails.isEmpty()) {
            System.out.println("Error: empty document key!");
            return;
        }

        String document = remoteDocumentStorage.get(commandDetails);

        if (document != null) {
            System.out.println(document);
        }
    }
}
