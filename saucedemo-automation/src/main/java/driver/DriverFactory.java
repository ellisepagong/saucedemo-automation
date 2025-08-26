package driver;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.*;

public class DriverFactory {

    private static final String DRIVER_PATH = "PATH_TO_DRIVER";

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null) {
            EdgeOptions options = new EdgeOptions();
            System.setProperty("webdriver.edge.driver", DRIVER_PATH);
            driver = new EdgeDriver(options);
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
