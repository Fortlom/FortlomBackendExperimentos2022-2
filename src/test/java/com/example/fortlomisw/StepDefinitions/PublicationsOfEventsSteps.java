package com.example.fortlomisw.StepDefinitions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import java.util.Random;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class PublicationsOfEventsSteps {
    WebDriver driver = null;
    String[] listEvents = new String[]{"event1","event2","event3","event4","event5","event6","event7"};
    int indice;
    Random r = new Random();

    @Given("that the artist is on Event section")
    public void that_the_artist_is_on_Event_section() throws InterruptedException {
        System.out.println("Inside Step - browser is open");
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is : "+projectPath);
        System.out.println("Project path is : "+projectPath+"/src/test/resources/Drivers/chromedriver.exe ");
        System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe ");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost:4200/");
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("alianza");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("nueva");
        driver.findElement(By.id("enter")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Event")).click();

    }

    @When("press the button Post Event")
    public void press_the_button_Post_Event() {
        driver.findElement(By.id("buttonPostEvent")).click();
    }

    @When("fill in the data correctly")
    public void fill_in_the_data_correctly() throws InterruptedException{
        indice = r.nextInt(7);
        driver.findElement(By.id("seteventname")).clear();
        driver.findElement(By.id("seteventdescription")).clear();
        driver.findElement(By.id("setdate")).clear();

        driver.findElement(By.id("seteventname")).sendKeys(listEvents[indice]);

        driver.findElement(By.id("seteventdescription")).sendKeys("eu facilisis magna. Nam convallis diam vitae sem fermentum, vitae suscipit nibh feugiat. Aenean Nulla facilisi. Aliquam quam urna, maximus eget tincidunt tempor, efficitur a dui.");
        driver.findElement(By.id("setdate")).sendKeys("25/05/2022");
        Thread.sleep(2000);
    }

    @When("press the button Create and Post")
    public void press_the_button_Create_and_Post() {
        driver.findElement(By.id("buttonCreateAndPost")).click();
    }

    @Then("an event will be created successfully")
    public void an_event_will_be_created_successfully() throws InterruptedException{
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }

    @When("do not fill in the form")
    public void do_not_fill_in_the_form() {
        driver.findElement(By.id("seteventname")).clear();
        driver.findElement(By.id("seteventdescription")).clear();
        driver.findElement(By.id("setdate")).clear();
    }

    @Then("the event will not be created")
    public void the_event_will_not_be_created() throws InterruptedException{
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }

    @When("press the button Show All Events")
    public void press_the_button_Show_All_Events() {
        driver.findElement(By.id("buttonShowAllEvents")).click();
    }

    @Then("all events will be displayed")
    public void all_events_will_be_displayed() throws InterruptedException{
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }

    @When("press the button Not Show Events")
    public void press_the_button_Not_Show_Events() {
        driver.findElement(By.id("buttonNotShowEvents")).click();
    }

    @Then("events will not be displayed")
    public void events_will_not_be_displayed() throws InterruptedException{
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }
}
