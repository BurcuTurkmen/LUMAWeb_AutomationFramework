package POM;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class PurchasePage extends BasePOM{


    public PurchasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Shop New Yoga']")
    private WebElement shopYogaButton;

    @FindAll(@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/a/span/span/img"))
    private WebElement echoFitShort;

    @FindAll(@FindBy(css = "#option-label-size-143-item-171"))
    public List<WebElement> selectSize;

    @FindAll(@FindBy(css = "#option-label-color-93-item-49"))
    public List<WebElement> selectColor;

    @FindBy(id = "product-addtocart-button")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='message-success success message']")
    private WebElement cartValidationMessage;

    @FindBy(xpath = "//a[@class='action showcart']")
    private WebElement shoppingCartButton;

    @FindBy(xpath = "//div[@class='primary']//button[1]")
    private WebElement proceedToCheckout;

    @FindBy(css = "#checkout-shipping-method-load > table > tbody > tr:nth-child(1) > td:nth-child(1) > input")
    private WebElement shippingMethodBtn;

    @FindBy(css = "button[class='button action continue primary']")
    private WebElement nextButton;

    @FindBy(css = "body[class='checkout-index-index page-layout-checkout']")
    private WebElement mainBody;

    @FindBy(xpath = "//*[@id='checkout-payment-method-load']/div/div/div[2]/div[2]/div[4]/div/button")
    private WebElement placeOrder;

    @FindBy(xpath = "//span[text()='Thank you for your purchase!']")
    private WebElement thankYouMessage;

    String expectedCartValidationMessage = "You added Echo Fit Compression Short to your shopping cart.";

    public void userSelectProduct(){
        shopYogaButton.click();
        echoFitShort.click();
        waitUntilVisibleAndClickableThenClick(selectSize.get(0));
        waitUntilVisibleAndClickableThenClick(selectColor.get(0));
        addToCartButton.click();

    }

    public void addProductValidation() {
        wait.until(ExpectedConditions.visibilityOf(cartValidationMessage));
        Assert.assertTrue(cartValidationMessage.isDisplayed());
        Assert.assertEquals(cartValidationMessage.getText(), expectedCartValidationMessage);

    }

    public void proceedToCheckout() {
        waitUntilVisibleAndClickableThenClick(shoppingCartButton);
        waitUntilVisibleAndClickableThenClick(proceedToCheckout);
        shippingMethodBtn.click();
        //waitUntilVisibleAndClickableThenClick(shipHereButton);
        waitUntilVisibleAndClickableThenClick(nextButton);

        //wait.until(ExpectedConditions.urlContains("#payment"));
        Driver.wait(2);
        wait.until(ExpectedConditions.attributeContains(mainBody, "aria-busy", "false"));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(placeOrder))).click().build().perform();

    }

    public void thankYouMessage() {
        wait.until(ExpectedConditions.urlContains("success"));
        Assert.assertTrue(thankYouMessage.isDisplayed());
        Assert.assertTrue(thankYouMessage.getText().toLowerCase().contains("Thank you".toLowerCase()));

    }

}
