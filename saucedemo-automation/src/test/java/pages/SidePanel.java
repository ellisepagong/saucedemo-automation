package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SidePanel extends BasePage{

    private static By sidePanelHamburger = By.cssSelector(".bm-burger-button");
    private static By sidePanelContainer = By.cssSelector(".bm-menu");

    private static By closePanelButton = By.cssSelector(".bm-cross-button");
    private static By logoutButton = By.id("logout_sidebar_link");

    public void logout(){
        click(sidePanelHamburger);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(logoutButton));
        click(logoutButton);
    }


}
