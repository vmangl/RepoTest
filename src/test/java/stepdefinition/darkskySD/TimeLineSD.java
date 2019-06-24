package stepdefinition.darkskySD;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.webPages.DarkSkyHomePage;
import org.testng.Assert;
import stepdefinition.SharedSD;

public class TimeLineSD {

    private DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();


    @Given("^I am on Darksky Home Page$")
    public void darkSkyHomePage(){
        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(), "https://darksky.net/forecast/40.7127,-74.0059/us12/en","Invalid Homepage");
    }

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void verifyTimeline(){


        Assert.assertEquals(darkSkyHomePage.hoursTimess(), darkSkyHomePage.SystemHourss());
    }
}
