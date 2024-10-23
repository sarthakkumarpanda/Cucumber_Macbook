package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        dryRun = false,
        monochrome = true,
        features = {"src/test/resources/feature_files/Add2Cart.feature" },
        glue     = {"step_definitions", "hooks"},
        tags = "@Add2CartWithLoginWithValidProduct",
        plugin = {"pretty", "html:target/site/cucumber-report.html", "json:target/cucumber1.json"},
        publish = false
)

public class Runner_TestNG extends AbstractTestNGCucumberTests {
}
