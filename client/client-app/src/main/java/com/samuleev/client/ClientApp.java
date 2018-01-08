package com.samuleev.client;

import com.samuleev.client.commands.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ClientApp implements CommandLineRunner {

    @Autowired
    private CommandFactory commandFactory;

    public static void main(String args[]) {
        SpringApplication app = new SpringApplication(ClientApp.class);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        printHelp();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            String commandCode = FirstTokenSeparateUtil.getFirstToken(input);
            CommandName commandName = CommandName.getByCode(commandCode);

            if (commandName == null) {
                System.out.println("Unknown command!");
                continue;
            }

            switch (commandName) {
                case HELP :
                    printHelp();
                    break;

                case QUIT :
                    System.out.println("Bye!");
                    scanner.close();
                    return;

                default :
                    Command command = commandFactory.getCommand(commandName);
                    String commandDetails = FirstTokenSeparateUtil.getRest(input);
                    command.execute(commandDetails);
                    break;
            }
        }
    }

    private void printHelp(){
        System.out.println("Available commands:");
        CommandName.printCommands();
        System.out.println();
    }
}
