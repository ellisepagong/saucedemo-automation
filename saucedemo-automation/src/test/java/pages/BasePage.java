package pages;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
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

    public void verifyPage(String title){
        if (!Objects.equals(driver.getTitle(), title)){
            throw new IllegalStateException("This is not "+ title +
                    ", current page is: " + driver.getCurrentUrl());
        }
    }

    public void navigate(String url) {
        driver.get(url);
    }
}

