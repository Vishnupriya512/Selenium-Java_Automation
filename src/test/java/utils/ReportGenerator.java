package utils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReportGenerator {

    public static void generateReport() {
        File outputDir = new File("target/cucumber-reports");

        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber-reports/cucumber.json");

        Configuration config = new Configuration(
                outputDir, "Selenium BDD Framework");

        ReportBuilder reportBuilder =
                new ReportBuilder(jsonFiles, config);
        reportBuilder.generateReports();
    }
}
