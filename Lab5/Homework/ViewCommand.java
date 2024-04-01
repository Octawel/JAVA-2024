package Homework;

import java.awt.Desktop;
import java.io.File;

public class ViewCommand implements Command {
    @Override
    public void execute(String[] args) throws Exception {
        if (args.length < 1) {
            throw new IllegalArgumentException("No document specified.");
        }
        File document = new File(args[0]);
        if (!document.exists()) {
            throw new IllegalArgumentException("Document does not exist.");
        }
        Desktop.getDesktop().open(document);
    }
}
