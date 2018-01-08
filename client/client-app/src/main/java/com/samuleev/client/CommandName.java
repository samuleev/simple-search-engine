package com.samuleev.client;

public enum CommandName {

    PUT("p", "Put documents into the search engine by key.\n" +
            "    usage: p <key> <document content>\n" +
            "    example: p 001 Lorem ipsum dolor sit amet"),

    GET("g", "Get document by key.\n" +
            "    usage: g <key>\n" +
            "    example: g 001"),

    SEARCH("s", "Search on a string of tokens to return keys of all documents that contain all tokens in the set.\n" +
            "    usage: s <string of tokens>\n" +
            "    example: s ipsum amet"),

    HELP("h", "Print help"),

    QUIT("q", "Quit");

    private final String code;
    private final String description;

    CommandName(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static CommandName getByCode(String code) {
        for (CommandName commandName : CommandName.values()) {
            if (commandName.getCode().equals(code)) {
                return commandName;
            }
        }
        return null;
    }

    public static void printCommands() {
        for (CommandName commandName : CommandName.values()) {
            System.out.println(commandName.getCode() + " - " + commandName.getDescription());
        }
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }


}
