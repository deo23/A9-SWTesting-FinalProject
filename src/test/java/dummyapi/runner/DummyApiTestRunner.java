package dummyapi.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/dummyapi", glue = "dummyapi.steps", plugin = { "pretty",
                "json:target/cucumber-reports/DummyApiReport.json" })
public class DummyApiTestRunner {
}