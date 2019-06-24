package stepdefinition.darkskySD;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkSkyHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.util.ArrayList;
import java.util.List;

public class TemperatureTimelineSD {

    private DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

//    @Given("^I am on Darksky Home Page$")
//    public void darkSkyHomePage(){
//        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(), "https://darksky.net/forecast/40.7127,-74.0059/us12/en","Invalid Homepage");
//    }

    @When("^I expand todays timeline$")
        public void expandTodayTemp() throws InterruptedException{
            darkSkyHomePage.todayTempLine();
        }


    @Then("^I verify current temp is not greater or less then temps from daily timeline$")
    public void verifyTempTimeline(){

        darkSkyHomePage.tempTimeline();

        Assert.assertTrue(darkSkyHomePage.isValidTemp,"The temperature displayed is inaccurate");
    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void verifyTodayTempDisp(){

        Assert.assertEquals(darkSkyHomePage.todayMinTempBar,darkSkyHomePage.todayMinTempDetails, "Today's min temperatures are displayed inaccurately");

        Assert.assertEquals(darkSkyHomePage.todayMaxTempBar,darkSkyHomePage.todayMaxTempDetails, "Today's max temperatures are displayed inaccurately");
    }




}
