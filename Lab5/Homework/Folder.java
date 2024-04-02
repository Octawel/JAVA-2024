package Homework;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String name;
    private List<File> files = new ArrayList<>();

    // Constructor
    public Folder() {
    }

    // Getter and setter for the name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter for the files (already existing, presumably)
    public List<File> getFiles() {
        return files;
    }

    // Setter for the files
    public void setFiles(List<File> files) {
        this.files = files;
    }
}

