package Homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.nio.file.Paths;
import java.util.List;

public class ExportCommand implements Command {
    private static final String MASTER_DIRECTORY_PATH = "D:\\facultate\\3E4-2\\Java\\Lab5\\MasterDirectory";

    @Override
    public void execute(String[] args) throws Exception {
        DirectoryReader directoryReader = new DirectoryReader();
        List<Folder> listOfFolders = directoryReader.readDirectoryStructure(Paths.get(MASTER_DIRECTORY_PATH));

        ObjectMapper mapper = new ObjectMapper();
        String jsonOutputPath = args.length > 0 ? args[0] : "masterDirectory.json";
        mapper.writeValue(new File(jsonOutputPath), listOfFolders);

        System.out.println("Repository exported to JSON in " + jsonOutputPath);
    }
}


