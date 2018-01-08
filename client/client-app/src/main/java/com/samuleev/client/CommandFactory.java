package com.samuleev.client;

import com.samuleev.client.commands.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandFactory {

    @Autowired
    private Command putCommand;

    @Autowired
    private Command getCommand;

    @Autowired
    private Command searchCommand;

    public Command getCommand(CommandName commandName) {
        switch (commandName) {
            case PUT : return putCommand;
            case GET : return getCommand;
            case SEARCH : return searchCommand;
        }
        return null;
    }

}
