package Homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandProcessor {
    private Map<String, Command> commands = new HashMap<>();

    public CommandProcessor() {
        commands.put("view", new ViewCommand());
        commands.put("report", new ReportCommand());
        commands.put("export", new ExportCommand());
        commands.put("exit", new ExitCommand());
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] parts = input.split("\\s+");
            if (parts.length == 0) continue;
            Command command = commands.get(parts[0]);
            if (command != null) {
                try {
                    command.execute(java.util.Arrays.copyOfRange(parts, 1, parts.length));
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
            } else {
                System.out.println("Unknown command.");
            }
        }
    }
}

