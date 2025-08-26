package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LoginPage;

public class LoginSteps {

    private final LoginPage page = new LoginPage();

    @Given("I am on the home page")
    public void i_am_on_the_home_page(){
        page.navigate();
    }

    @When("I enter {string} and {string} in login details")
    public void i_enter_login_details(String username, String pass){
        page.enterUsername(username);
        page.enterPassword(pass);
    }

    @When("I click login")
    public void i_click_login(){
        page.clickLogin();
    }

    @Then("error message should appear")
    public void error_message_should_appear(){
        Assert.assertFalse(page.checkErrorMessage());
    }

}
