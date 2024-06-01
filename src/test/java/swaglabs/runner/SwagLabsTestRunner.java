package swaglabs.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/swaglabs", glue = "swaglabs.steps", plugin = { "pretty",
        "json:target/cucumber-reports/SwagLabsReport.json" }, strict = true)
public class SwagLabsTestRunner {
}
