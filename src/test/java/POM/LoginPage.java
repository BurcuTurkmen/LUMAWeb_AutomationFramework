package POM;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePOM{



    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    private WebElement signIn;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(xpath = "(//button[@id='send2'])[1]")
    private WebElement signInButton;

    @FindBy(xpath = "//span[text()='Welcome, Betty Swanson!'][1]")
    private WebElement welcomeMessage;


    private String email = "bcf@gmail.com";
    private String password = "Bs123987645!";





    public void validateUserOnLoginPage() {
        wait.until(ExpectedConditions.elementToBeClickable(signIn)).click();
        Assert.assertTrue(emailInput.isDisplayed());
        Assert.assertTrue(passwordInput.isDisplayed());
        Assert.assertTrue(signInButton.isDisplayed());
    }

    public void userEnterValidCredentials() {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();
    }

    public void validateUserSuccessfullyLoggedIn() {
        wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
        Assert.assertTrue(welcomeMessage.isDisplayed());

    }

}




