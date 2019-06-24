package stepdefinition.darkskySD;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkSkyHomePage;
import org.testng.Assert;
import stepdefinition.SharedSD;

public class SignUpSD {

    private DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

    @Given("^I am on DarkSKy home page$")
    public void darkSkyHomePage(){
        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(), "https://darksky.net/forecast/40.7127,-74.0059/us12/en","Invalid Homepage");
    }

    @When("^I am on the darksky Register page$")
    public void darkSKyRegisterPage(){
        darkSkyHomePage.clickOnDarkSkyApi();

        darkSkyHomePage.clickOnSignUpButton();
    }

    @When("^I click on Register button$")
    public void registerButton(){
        darkSkyHomePage.clickOnRegisterButton();
    }


    @Then("^I verify error message please fill out this field$")
    public void verifyRegisterPage(){
        darkSkyHomePage.verifyIAmOnRegisterPage();
    }




}
