package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final String LOGIN_ADDRESS = "https://www.saucedemo.com/v1";

    // Element Locators
    private final By usernameForm = By.xpath("//*[@id=\"user-name\"]");
    private final By passwordForm = By.xpath("//*[@id=\"password\"]");
    private final By loginButton = By.xpath("//*[@id=\"login-button\"]");
    private final By errorContainer = By.xpath("//*[@id=\"login_button_container\"]/div/form/h3");


    public void enterUsername(String username){
        type(usernameForm, username);
    }

    public void enterPassword(String password){
        type(passwordForm, password);
    }

    public void clickLogin(){
        click(loginButton);
    }

    public Boolean checkErrorMessage(){
        return elementExists(errorContainer);
    }

    public void navigate(){
        navigate(LOGIN_ADDRESS);
    }

    public String getErrorMessage() {
        return getText(errorContainer);
    }
}
