package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DialogContentElements extends BasePOM {


    public DialogContentElements() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "span[class='customer-name']")
    private WebElement menuSwitch;

    @FindBy(linkText = "My Account")
    private WebElement myAccount;

    @FindBy(linkText = "Manage Addresses")
    private WebElement manageAddress;

    @FindBy(xpath = "//span[text()='Add New Address']")
    private WebElement newAddressHeader;

    @FindBy(id = "telephone")
    private WebElement phoneNumberInput;

    @FindBy(id = "street_1")
    private WebElement streetAddressInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "region_id")
    private WebElement stateDropdown;

    @FindBy(id = "zip")
    private WebElement zipCodeInput;

    @FindBy(xpath = "//button[@class='action save primary']")
    private WebElement saveAddressButton;

    @FindBy(xpath = "//div[@class='message-success success message']")
    private WebElement successMessage;

    @FindBy(xpath = "//button[@class='action primary add']")
    private WebElement addNewAddress;



    String expectedMessage = "You saved the address.";

    public void userNavigateMyAccountPage() {
        wait.until(ExpectedConditions.elementToBeClickable(menuSwitch)).click();
        myAccount.click();
    }

    public void userClickOnManageAddresses() {
        wait.until(ExpectedConditions.visibilityOf(manageAddress)).click();
        Assert.assertTrue(newAddressHeader.isDisplayed());
        addNewAddress.click();
    }

    public void userAddNewAddress(String phoneNumber, String streetAddress, String city, String state, String zipCode) {
        phoneNumberInput.sendKeys(phoneNumber);
        streetAddressInput.sendKeys(streetAddress);
        cityInput.sendKeys(city);
        Select selectState = new Select(stateDropdown);
        selectState.selectByVisibleText("Illinois");
        stateDropdown.sendKeys(state);
        zipCodeInput.sendKeys(zipCode);
        saveAddressButton.click();

    }

    public void validateSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        Assert.assertTrue(successMessage.getText().contains("address".toLowerCase()));
        Assert.assertEquals(successMessage.getText(), expectedMessage);

    }



        }
