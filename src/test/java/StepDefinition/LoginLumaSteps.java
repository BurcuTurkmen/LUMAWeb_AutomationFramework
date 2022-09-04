package StepDefinition;

import POM.DialogContentElements;
import POM.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginLumaSteps {

    LoginPage loginPage;
    //DialogContentElements dialogContentElements;

    @Given("User is on login page")
    public void userIsOnLoginPage() {
       //dialogContentElements = new DialogContentElements();
        loginPage = new LoginPage();
        loginPage.validateUserOnLoginPage();
    }

    @When("User enter valid credentials")
    public void userEnterValidCredentials() {
        loginPage = new LoginPage();
        loginPage.userEnterValidCredentials();
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        loginPage = new LoginPage();
        loginPage.validateUserSuccessfullyLoggedIn();
    }
}
