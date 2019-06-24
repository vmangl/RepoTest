package framework.webPages;

import gherkin.lexer.Ca;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.*;
import java.lang.*;

public class DarkSkyHomePage extends BasePage {

    private By darkSkyApiButton = By.xpath("//div[@class='inner']//a[contains(text(),'Dark Sky API')]");
    private By signUpButton = By.xpath("//a[@class='button filled']");
    private By registerButton = By.xpath("//button[contains(text(),'Register')]");
    private By currentTemp = By.xpath("//span[@class='first']");
    private By todayTemp = By.xpath("//*[@class='day'][@data-day='0']//*[@class='toggle']");
    private By tempLineHours = By.xpath("//div[@id='timeline']//div[@class='hours']/span[contains(@class,'hour')]/span");

    public String todayMinTempBar;
    public String todayMinTempDetails;
    public String todayMaxTempBar;
    public String todayMaxTempDetails;



    public boolean isValidTemp;


    public void clickOnDarkSkyApi(){
        clickOn(darkSkyApiButton);
    }

    public void clickOnSignUpButton(){
        clickOn(signUpButton);
    }

    public void clickOnRegisterButton(){
        clickOn(registerButton);
    }


    public void verifyIAmOnRegisterPage(){

        String expectedRegister = SharedSD.getDriver().getTitle();
        String actualRegister = "Dark Sky API: Register";
        Assert.assertEquals(expectedRegister,actualRegister, "We didn't land on Register Page");
    }


    public void tempTimeline() {

        String currTemp = SharedSD.getDriver().findElement(By.xpath("//span[@class='first']")).getText();

        int currLineTemp = Integer.parseInt(currTemp.substring(0, currTemp.length()-1));

        List<WebElement> timelineTemp = SharedSD.getDriver().findElements(By.xpath("//*[@class='temps']//*[contains(@style,'opacity:')]//span"));

        ArrayList<String> tempList = new ArrayList<String>();

        for (WebElement timelineTemps : timelineTemp) {

            tempList.add(timelineTemps.getText().substring(0, timelineTemps.getText().length()-1));

            //int lineTemp = Integer.parseInt(timelineTemps.getText().substring(0, timelineTemps.getText().length()-1));

            Collections.sort(tempList);

            String highTemp = Collections.max(tempList);

            int highTemperature = Integer.parseInt(highTemp);

            String lowTemp = Collections.min(tempList);

            int lowTemperature = Integer.parseInt(lowTemp);

            isValidTemp = true;

            if (currLineTemp < lowTemperature || currLineTemp > highTemperature){

                isValidTemp = false;

            }
            Assert.assertTrue(isValidTemp);

        }

    }

    public void todayTempLine() throws InterruptedException {

        SharedSD.getDriver().manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();

        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0,1000)", "");
        Thread.sleep(2000);

        clickOn(todayTemp);

        todayMinTempBar = SharedSD.getDriver().findElement(By.xpath("//*[@class='day revealed'][@data-day='0']//*[@class='minTemp']")).getText();

        todayMinTempDetails = SharedSD.getDriver().findElement(By.xpath("//div[@class='dayDetails revealed']//span[@class='highTemp swip']//span[@class='temp']")).getText();

        todayMaxTempBar = SharedSD.getDriver().findElement(By.xpath("//*[@class='day revealed'][@data-day='0']//*[@class='maxTemp']")).getText();

        todayMaxTempDetails = SharedSD.getDriver().findElement(By.xpath("//div[@class='dayDetails revealed']//span[@class='lowTemp swap']//span[@class='temp']")).getText();

    }
    public List SystemHourss(){

        List<String> listOfSystemHours = new ArrayList();

        Calendar cal = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("ha");

        cal.getTime();

        for (int i = 1; i < 11; i++){

            cal.add(Calendar.HOUR_OF_DAY,2);

            String systemHoursList = sdf.format(cal.getTime());

            listOfSystemHours.add(systemHoursList);
        }
        return listOfSystemHours;

    }


    public List hoursTimess(){

        List <String> timeListHours = new ArrayList<>();

        List<WebElement> timeLineList = SharedSD.getDriver().findElements(tempLineHours);

        for (int i = 1; i<11; i++){

            String time = timeLineList.get(i).getText().toUpperCase();

            timeListHours.add(time);

        } return timeListHours;

    }
}
