package Homework;

public class ExitCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println("Exiting application...");
        System.exit(0);
    }
}

