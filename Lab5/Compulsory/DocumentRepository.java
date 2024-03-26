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
            Files.createDirectories(masterDirectoryPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPerson(Person person) {
        Path personDirectory = masterDirectoryPath.resolve(person.id());
        try {
            Files.createDirectories(personDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayRepositoryContents() {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(masterDirectoryPath)) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    System.out.println("Director: " + entry.getFileName());
                    try (DirectoryStream<Path> personStream = Files.newDirectoryStream(entry)) {
                        for (Path file : personStream) {
                            if (Files.isRegularFile(file)) {
                                System.out.println("  Document: " + file.getFileName());
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
