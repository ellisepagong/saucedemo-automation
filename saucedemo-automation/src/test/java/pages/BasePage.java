package pages;

import driver.DriverFactory;
import org.openqa.selenium.*;

import java.util.Objects;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
    }

    public void click(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(locator));
    }

    public void type(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.click();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public boolean elementExists(By locator){
        try{ //Check if error message exists
            WebElement errorMessageContainer = driver.findElement(locator);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }

    public Boolean verifyPage(String url){
        return Objects.equals(driver.getCurrentUrl(), url);
    }

    public void navigate(String url) {
        driver.get(url);
    }
}

