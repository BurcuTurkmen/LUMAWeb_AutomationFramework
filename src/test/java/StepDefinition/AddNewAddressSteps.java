package StepDefinition;

import POM.DialogContentElements;
import POM.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewAddressSteps {

    DialogContentElements dialogContentElements;

    @When("User navigate to My Account page")
    public void userNavigateToMyAccountPage() {
        dialogContentElements = new DialogContentElements();
        dialogContentElements.userNavigateMyAccountPage();
    }

    @Then("User click on Manage Addresses")
    public void userClickOnManageAddresses() {
        dialogContentElements = new DialogContentElements();
        dialogContentElements.userClickOnManageAddresses();
    }

    @Then("User add a new address and fill {string} and {string} and {string} and {string} and {string}")
    public void userAddANewAddressAndFillAndAndAndAnd(String phoneNumber, String streetAddress, String city, String state, String zipCode) {
        dialogContentElements = new DialogContentElements();
        dialogContentElements.userAddNewAddress(phoneNumber, streetAddress, city, state, zipCode);
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dialogContentElements = new DialogContentElements();
        dialogContentElements.validateSuccessMessage();

    }



}
