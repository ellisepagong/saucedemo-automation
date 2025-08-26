import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",   // Path to feature files
        glue = {"steps"},                           // Package with step definitions & hooks
        plugin = {
                "pretty",                               // Console output
                "html:target/cucumber-reports.html",    // HTML report
                "json:target/cucumber.json"             // JSON report
        },
        monochrome = true,                          // Clean console output
        tags = "@IncorrectCredentials"                         // Optional: run specific tagged scenarios
)
public class Runner {
}
