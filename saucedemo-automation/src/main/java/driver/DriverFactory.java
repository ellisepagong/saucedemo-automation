package driver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.*;

public class DriverFactory {

    private static final String DRIVER_PATH = "PATH_TO_DRIVER";

    private static WebDriver driver;
    private DriverFactory(){

    }

    public static WebDriver getDriver(){
        if (driver == null) {
            String env = System.getProperty("env", "local");
            if (env.equalsIgnoreCase("ci")) {
                // Run on Headless mode for GitHub Actions
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                driver = new ChromeDriver(options);
            } else {
                EdgeOptions options = new EdgeOptions();
                System.setProperty("webdriver.edge.driver", DRIVER_PATH);
                driver = new EdgeDriver(options);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
