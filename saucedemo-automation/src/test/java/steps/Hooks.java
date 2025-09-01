package steps;

import driver.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {


    @Before
    public void setUp(Scenario scenario) {
        System.out.println("Starting scenario: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Scenario failed: " + scenario.getName());
            WebDriver driver = DriverFactory.getDriver();
            TakesScreenshot ts = (TakesScreenshot) driver;

            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }
        System.out.println("Finished scenario: " + scenario.getName());
        DriverFactory.quitDriver();
    }
}

