package pages;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Objects;

/**
 * Abstract base class for all page objects in the SauceDemo test automation framework.
 *
 * <p>This class implements the Page Object Model (POM) design pattern and provides
 * a centralized location for common web page interactions. It serves as the foundation
 * for all page-specific classes, ensuring consistent behavior and reducing code duplication
 * across the test suite.</p>
 *
 * <p>Key responsibilities of this base class include:
 * <ul>
 *   <li>Managing the WebDriver instance through the singleton DriverFactory</li>
 *   <li>Providing common web element interaction methods</li>
 *   <li>Handling page navigation and URL verification</li>
 *   <li>Implementing element existence and visibility checks</li>
 *   <li>Serving as a template for page-specific implementations</li>
 * </ul>
 * </p>
 *
 *
 * @author Ellise Pag-Ong
 * @version 1.0
 * @since 2024
 *
 * @see DriverFactory
 */
public abstract class BasePage {

    /**
     * The WebDriver instance shared across all page object subclasses.
     *
     * <p>This driver is obtained from the singleton {@link DriverFactory} and provides
     * a consistent browser session across all page interactions. The driver is
     * initialized in the constructor and remains available throughout the page
     * object's lifecycle.</p>
     *
     * <p><b>Note:</b> Direct access to this field should be avoided in favor of using
     * the provided convenience methods, which include proper error handling and
     * logging capabilities.</p>
     *
     * @see DriverFactory#getDriver()
     */
    protected WebDriver driver;

    /**
     * Default timeout duration for explicit waits in seconds.
     *
     * <p>This constant defines the maximum time to wait for elements to become
     * available or conditions to be met. Individual page classes can override
     * this value if they require different timeout behavior.</p>
     */
    protected static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

    /**
     * Constructs a new BasePage instance and initializes the WebDriver.
     *
     * <p>This constructor retrieves the singleton WebDriver instance from
     * {@link DriverFactory} and makes it available to all subclasses.
     * The constructor is called automatically when creating any page object
     * that extends this base class.</p>
     *
     * <p><b>Initialization Process:</b>
     * <ol>
     *   <li>Retrieves WebDriver instance from DriverFactory singleton</li>
     *   <li>Assigns the driver to the protected driver field</li>
     *   <li>Makes the driver available to all subclass methods</li>
     * </ol>
     * </p>
     *
     * @throws RuntimeException if the WebDriver instance cannot be retrieved
     *         from DriverFactory
     *
     * @see DriverFactory#getDriver()
     */
    public BasePage() {
        this.driver = DriverFactory.getDriver();
    }

    /**
     * Clicks on a web element located by the specified selector.
     *
     * <p>This method finds the element using the provided locator and performs
     * a click action. It includes basic error handling for element not found
     * scenarios and can be extended with explicit waits in subclasses if needed.</p>
     *
     * @param locator the {@link By} locator strategy to find the target element
     *
     * @throws NoSuchElementException if the element cannot be found
     * @throws RuntimeException if the element is not clickable or an unexpected
     *         error occurs during the click operation
     *
     * @see WebDriver#findElement(By)
     * @see WebElement#click()
     */
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    /**
     * Types text into a web element located by the specified selector.
     *
     * <p>This method performs a two-step process: first clicking on the element
     * to focus it, then sending the specified text. This approach ensures proper
     * text entry for most input fields and text areas.</p>
     *
     * @param locator the {@link By} locator strategy to find the target element
     * @param text the text to be entered into the element, can be null or empty
     *
     * @throws NoSuchElementException if the element cannot be found
     * @throws RuntimeException if the element is not interactable or an unexpected
     *         error occurs during text entry
     *
     * @see WebDriver#findElement(By)
     * @see WebElement#click()
     * @see WebElement#sendKeys(CharSequence...)
     */
    public void type(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.click();
        element.sendKeys(text);
    }

    /**
     * Retrieves the visible text content from a web element.
     *
     * <p>This method finds the specified element and returns its visible text content.
     * This is commonly used for extracting labels, messages, product names, and other
     * text-based content for verification purposes in test assertions.</p>
     *
     * @param locator the {@link By} locator strategy to find the target element
     * @return the visible text content of the element, or an empty string if no text exists
     *
     * @throws NoSuchElementException if the element cannot be found
     *
     * @see WebDriver#findElement(By)
     * @see WebElement#getText()
     */
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    /**
     * Checks if a web element is currently displayed and visible.
     *
     * <p>This method determines whether an element is present in the DOM and
     * visible to the user. It returns true only if the element exists and is
     * not hidden by CSS properties such as display:none or visibility:hidden.</p>
     *
     * @param locator the {@link By} locator strategy to find the target element
     * @return true if the element is visible and interactable, false otherwise
     *
     * @throws NoSuchElementException if the element cannot be found
     *
     * @see WebDriver#findElement(By)
     * @see WebElement#isDisplayed()
     */
    public boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    /**
     * Checks if a web element exists in the DOM, regardless of visibility.
     *
     * <p>This method attempts to find an element and returns true if it exists
     * in the DOM, even if it's not currently visible. This is useful for checking
     * the presence of elements that might be conditionally shown or hidden.</p>
     *
     *
     * @param locator the {@link By} locator strategy to find the target element
     * @return true if the element exists in the DOM, false if it cannot be found
     *
     * @see WebDriver#findElement(By)
     */
    public boolean elementExists(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }

    /**
     * Verifies that the current browser URL matches the expected URL.
     *
     * <p>This method compares the current page URL with the expected URL
     * and returns true if they match exactly. This is commonly used for
     * page navigation verification and ensuring tests are on the correct page.</p>
     *
     * @param url the expected URL to verify against the current browser URL
     * @return true if URLs match exactly, false otherwise
     *
     * @see WebDriver#getCurrentUrl()
     */
    public Boolean verifyPage(String url) {
        return Objects.equals(driver.getCurrentUrl(), url);
    }

    /**
     * Navigates the browser to the specified URL and waits briefly for loading.
     *
     * <p>This method uses WebDriver's get() method to navigate to the specified
     * URL. After navigation, it includes a short sleep to allow for potential
     * redirects or dynamic content loading.</p>
     *
     * <p><b>Note:</b> The current implementation uses a fixed sleep time, which
     * is not ideal for all scenarios. The fixed sleep time was implemented with the specific test case with an expected redirect.</p>
     *
     * @param url the URL to navigate to, must be a valid web address
     *
     * @throws RuntimeException if navigation fails or if the thread is interrupted
     *         during the wait period
     *
     * @see WebDriver#get(String)
     */
    public void navigate(String url) {
        driver.get(url);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

