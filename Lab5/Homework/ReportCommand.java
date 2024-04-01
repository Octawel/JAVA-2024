package Homework;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand implements Command {
    @Override
    public void execute(String[] args) throws Exception {
        Configuration cfg = new Configuration(new Version("2.3.31"));
        cfg.setClassForTemplateLoading(ReportCommand.class, "/");
        cfg.setDefaultEncoding("UTF-8");

        Template template = cfg.getTemplate("reportTemplate.ftl");

        Map<String, Object> templateData = new HashMap<>();
        templateData.put("message", "This is a test report.");

        File reportFile = File.createTempFile("report", ".html");
        try (Writer fileWriter = new FileWriter(reportFile)) {
            template.process(templateData, fileWriter);
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }

        Desktop.getDesktop().browse(reportFile.toURI());
    }
}

