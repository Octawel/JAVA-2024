package Homework;

import freemarker.template.*;
import java.awt.Desktop;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.io.File;
import java.io.FileOutputStream;


public class ReportCommand implements Command {
    @Override
    public void execute(String[] args) throws Exception {
        // Step 1: Load and configure FreeMarker
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(ReportCommand.class, "/");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);

        // Step 2: Prepare data model
        DirectoryReader directoryReader = new DirectoryReader();
        List<Folder> listOfFolders = directoryReader.readDirectoryStructure(Paths.get("D:\\facultate\\3E4-2\\Java\\Lab5\\MasterDirectory"));
        Map<String, Object> root = new HashMap<>();
        root.put("folders", listOfFolders);

        // Step 3: Generate report
        Template temp = cfg.getTemplate("reportTemplate.ftl");
        File reportFile = new File("report.html"); // Output file
        try (Writer out = new OutputStreamWriter(new FileOutputStream(reportFile))) {
            temp.process(root, out);
        }

        // Step 4: Open report in default browser
        Desktop.getDesktop().browse(reportFile.toURI());
    }
}
