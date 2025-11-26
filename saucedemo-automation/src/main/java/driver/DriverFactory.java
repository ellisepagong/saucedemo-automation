/**
 * A singleton factory class for creating and managing WebDriver instances.
 *
 * <p>This factory provides a centralized way to create WebDriver instances
 * for different browsers based on the environment configuration. It supports
 * both local development (using Microsoft Edge) and CI/CD environments (using
 * headless Chrome for GitHub Actions).</p>
 *
 * <p>The factory implements the singleton pattern to ensure that only one
 * WebDriver instance is created and shared across the application.</p>
 *
 * @author QA Automation Team
 * @version 1.0
 * @since 2024
 */
package driver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.*;

public class DriverFactory {

    /**
     * The file system path to the WebDriver executable.
     * This path is used when running tests in local environment.
     */
    private static final String DRIVER_PATH = "C:\\Users\\johan\\AppData\\Local\\edgedriver_win64\\msedgedriver.exe";

    /**
     * The singleton WebDriver instance managed by this factory.
     * This field is null until the first call to {@link #getDriver()}.
     */
    private static WebDriver driver;
    
    /**
     * Private constructor to prevent instantiation of this factory class.
     *
     * <p>This constructor is private to enforce the singleton pattern,
     * ensuring that no external code can create instances of this class.</p>
     */
    private DriverFactory() {

    }

    /**
     * Returns the singleton WebDriver instance, creating it if necessary.
     *
     * <p><b>Note:</b> EdgeDriver may be replaced with the appropriate WebDriver of a given browser.
     *
     * <p>This method implements lazy initialization of the WebDriver instance.
     * The browser type and configuration are determined by the "env" system property:
     * <ul>
     *   <li><b>ci</b> - Uses headless Chrome with specific options for CI/CD environments</li>
     *   <li><b>local</b> (default) - Uses Microsoft Edge with local WebDriver configuration</li>
     * </ul>
     * </p>
     *
     * <p>For CI environments, the following Chrome options are applied:
     * <ul>
     *   <li>--headless=new - Enables new headless mode</li>
     *   <li>--no-sandbox - Disables sandboxing for container environments</li>
     *   <li>--disable-dev-shm-usage - Prevents issues with /dev/shm</li>
     *   <li>--incognito - Enables incognito mode to prevent password security pop-up modal in certain browsers</li>
     * </ul>
     * </p>
     *
     * @return the WebDriver instance, never null after the first call
     *
     * @throws WebDriverException if the WebDriver cannot be instantiated
     *         due to missing drivers or incompatible browser versions
     *
     * @see ChromeDriver
     * @see EdgeDriver
     */
    public static WebDriver getDriver(){
        if (driver == null) {
            String env = System.getProperty("env", "local");
            if (env.equalsIgnoreCase("ci")) {
                // Run on Headless mode for GitHub Actions
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
            } else {
                EdgeOptions options = new EdgeOptions();
                System.setProperty("webdriver.edge.driver", DRIVER_PATH);
                driver = new EdgeDriver(options);
            }
        }
        return driver;
    }

    /**
     * Quits the WebDriver instance and sets it to null.
     *
     * <p>This method is called to properly clean up the WebDriver
     * instance when it's no longer needed, preventing multiple instances running in the background. It performs the following actions:
     * <ol>
     *   <li>Checks if the driver instance is not null</li>
     *   <li>Calls {@link WebDriver#quit()} to close all browser windows and terminate the WebDriver session</li>
     *   <li>Sets the static driver reference to null to allow garbage collection</li>
     * </ol>
     * </p>
     *
     * @see WebDriver#quit()
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
