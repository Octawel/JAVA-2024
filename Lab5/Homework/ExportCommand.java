package Homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ExportCommand implements Command {
    @Override
    public void execute(String[] args) throws Exception {
        if (args.length < 1) {
            throw new IllegalArgumentException("No output file specified.");
        }
        Map<String, Object> data = new HashMap<>();
        data.put("message", "This is a JSON export.");

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(args[0]), data);

        System.out.println("Data exported to " + args[0]);
    }
}


