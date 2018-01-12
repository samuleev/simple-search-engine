package com.samuleev.client;

import com.samuleev.client.commands.Command;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class CommandFactoryTest {

    private CommandFactory commandFactory;

    @Mock
    private Command putCommand;

    @Mock
    private Command getCommand;

    @Mock
    private Command searchCommand;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        commandFactory = new CommandFactory(putCommand, getCommand, searchCommand);
    }

    @Test
    public void testGetCommand() throws Exception {
        assertEquals(putCommand, commandFactory.getCommand(CommandName.PUT));
        assertEquals(getCommand, commandFactory.getCommand(CommandName.GET));
        assertEquals(searchCommand, commandFactory.getCommand(CommandName.SEARCH));
    }
}