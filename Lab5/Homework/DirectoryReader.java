package Homework;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class DirectoryReader {

    public List<Folder> readDirectoryStructure(Path startPath) throws IOException {
        List<Folder> folders = new ArrayList<>();

        Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
            private Folder currentFolder;

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                currentFolder = new Folder();
                currentFolder.setName(dir.getFileName().toString());
                currentFolder.setFiles(new ArrayList<>());
                folders.add(currentFolder);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                File fileInfo = new File();
                fileInfo.setName(file.getFileName().toString());
                fileInfo.setSize(attrs.size());
                fileInfo.setLastModified(Files.getLastModifiedTime(file).toString());
                currentFolder.getFiles().add(fileInfo);
                return FileVisitResult.CONTINUE;
            }
        });

        return folders;
    }
}
