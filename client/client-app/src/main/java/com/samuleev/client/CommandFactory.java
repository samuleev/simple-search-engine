package com.samuleev.client;

import com.samuleev.client.commands.Command;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class CommandFactory {

    private final @NonNull Command putCommand;

    private final @NonNull Command getCommand;

    private final @NonNull Command searchCommand;

    public Command getCommand(CommandName commandName) {
        switch (commandName) {
            case PUT : return putCommand;
            case GET : return getCommand;
            case SEARCH : return searchCommand;
        }
        return null;
    }

}
