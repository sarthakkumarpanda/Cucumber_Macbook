package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        dryRun = false,
        monochrome = true,
        features = {"src/test/resources/feature_files/" },
        glue     = {"step_definitions", "hooks"},
        tags = "@TutorialsNinjaLogin or @TutorialsNinjaRegister or @TutorialsNinjaSearchProduct",
        plugin = {"pretty", "html:target/site/cucumber-report.html", "json:target/cucumber1.json"},
        publish = true
)

public class Runner_TestNG extends AbstractTestNGCucumberTests {
}
