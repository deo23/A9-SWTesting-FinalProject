package swaglabs.utils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.Arrays;

public class CucumberReportGenerator {
    public static void main(String[] args) {
        File reportOutputDirectory = new File("target");
        // Adjust the JSON files list to include both test reports
        java.util.List<String> jsonFiles = Arrays.asList(
                "target/cucumber-reports/DummyApiReport.json",
                "target/cucumber-reports/SwagLabsReport.json");

        Configuration configuration = new Configuration(reportOutputDirectory, "swaglabs");
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", "Chrome");

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
