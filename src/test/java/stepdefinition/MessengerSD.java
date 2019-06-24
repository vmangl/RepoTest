package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HomePage;
import framework.webPages.MessengerLoginPage;
import framework.webPages.MessengerPage;
import org.testng.Assert;

public class MessengerSD{

    private HomePage homePage = new HomePage();
    private MessengerPage messengerPage = new MessengerPage();
    private MessengerLoginPage messengerLoginPage = new MessengerLoginPage();

    @Given("^I am on messenger page$")
    public void setMessengerPage() {
        homePage.clickOnMessengerLink();
        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(), "https://www.messenger.com/");
    }

    @When("^I enter (.+) into (username|password) field on messenger page$")
    public void enterDataOnMessengerPage(String value, String textField){

        switch (textField){
            case "email":
                messengerPage.enterEmail(value);
                break;

            case "password":
                messengerPage.enterPassword(value);
                break;
        }

    }

    @And("^I click on (signup) button on messenger page$")
    public void clickOnSignUpButton(String button){

        switch (button){

            case "signup":
                messengerPage.clickOnSignupButton();
                break;
        }

    }

    @Then("^I verify invalid login message on signup page$")
    public void verifyInvalidLoginMessage(){

        String expectedErrorMessage = messengerLoginPage.getErrorMessage();
        String actualErrorMessage = "Incorrect email or phone number";
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Cannot verify Error Message");
    }

}
