package View;

import Model.Command.Command;

import java.util.HashMap;
import java.util.Scanner;

class TextMenu {
    private HashMap<String, Command> commands;

    TextMenu() {
        this.commands = new HashMap<>();
    }

    void addCommand(Command c){
        commands.put(c.getKey(), c);
    }

    private void printMenu(){
        for(Command command : commands.values()){
            String line = String.format("%4s: %s", command.getKey(), command.getDescription());
            System.out.println(line);
        }
    }

    void show(){
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                printMenu();
                System.out.println("Input the option: ");
                String key = scanner.nextLine();
                Command com = commands.get(key);
                if (com == null) {
                    System.out.println("Invalid input");
                    continue;
                }
                com.execute();

            }
        }
    }
}
