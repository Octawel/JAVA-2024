package Compulsory;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DocumentRepository {
    private Path masterDirectoryPath;

    public DocumentRepository(String masterDirectory) {
        this.masterDirectoryPath = Paths.get(masterDirectory, "MasterDirectory");
        try {
            Files.createDirectories(masterDirectoryPath); // Crează MasterDirectory dacă nu există
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPerson(Person person) {
        Path personDirectory = masterDirectoryPath.resolve(person.id());
        try {
            Files.createDirectories(personDirectory); // Crează directorul persoanei dacă nu există
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayRepositoryContents() {
        try {
            displayDirectoryContents(masterDirectoryPath, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayDirectoryContents(Path directory, int level) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path entry : stream) {
                printEntry(entry, level);
                if (Files.isDirectory(entry)) {
                    // Recursiv pentru subdirectoare
                    displayDirectoryContents(entry, level + 1);
                }
            }
        }
    }

    private void printEntry(Path entry, int level) {
        // Crează un prefix bazat pe nivelul de adâncime pentru a indica ierarhia
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < level; i++) {
            prefix.append("  ");
        }
        if (Files.isDirectory(entry)) {
            System.out.println(prefix + "Director: " + entry.getFileName());
        } else {
            System.out.println(prefix + "Document: " + entry.getFileName());
        }
    }
}
