package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        tags = "@Regression",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/report.html",
                "json:target/cucumber-reports/cucumber.json",

        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
        @AfterClass(alwaysRun=true)
        public void generateHTMLReport(){
                super.tearDownClass();
                utils.ReportGenerator.generateReport();
        }
}
