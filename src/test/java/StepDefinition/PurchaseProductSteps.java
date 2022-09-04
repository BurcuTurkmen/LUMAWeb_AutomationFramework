package StepDefinition;

import POM.DialogContentElements;
import POM.PurchasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseProductSteps {

    PurchasePage purchasePage;


    @When("User select a product")
    public void userSelectAProduct() {
        purchasePage = new PurchasePage();
        purchasePage.userSelectProduct();
    }

    @Then("User added product to cart message should be displayed")
    public void userAddedProductToCartMessageShouldBeDisplayed() {
        purchasePage = new PurchasePage();
        purchasePage.addProductValidation();
    }


    @Then("User proceed to checkout")
    public void userProceedToCheckout() {
        purchasePage = new PurchasePage();
        purchasePage.proceedToCheckout();
    }


    @Then("Success checkout message should be displayed")
    public void successCheckoutMessageShouldBeDisplayed() {
        purchasePage = new PurchasePage();
        purchasePage.thankYouMessage();
    }
}
