package com.example.fortlomisw.StepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;


public class LikePublicationsEventsFanaticSteps {

    WebDriver driver = null;
    @Given("that the fanatic is at the  fan Publication section")
    public void that_the_fanatic_is_at_the_fan_Publication_section() throws InterruptedException {
        System.out.println("Inside Step - browser is open");
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is : "+projectPath);
        System.out.println("Project path is : "+projectPath+"/src/test/resources/Drivers/chromedriver.exe ");
        System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe ");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost:4200/");

        driver.findElement(By.id("exampleInputEmail1")).sendKeys("fan");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("nueva");
        driver.findElement(By.id("enter")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Publication")).click();
        Thread.sleep(2000);
    }
    @When("press the button  Like")
    public void press_the_button_Like() {
        driver.findElement(By.id("like")).click();
    }
    @Then("it will be noticed that the fanatic likes the publication")
    public void it_will_be_noticed_that_the_fanatic_likes_the_publication() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().alert().getText().equals("liked");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.close();
        driver.quit();

    }
    @When("press the button  Dislike")
    public void press_the_button_Dislike() {
        driver.findElement(By.id("dislike")).click();
    }

    @Then("it will be noticed that the fanatic does not like the publication")
    public void it_will_be_noticed_that_the_fanatic_does_not_like_the_publication() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().alert().getText().equals("disliked");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.close();
        driver.quit();
    }
    @Given("that the fanatic is at the Event section")
    public void that_the_fanatic_is_at_the_Event_section() throws InterruptedException{
        System.out.println("Inside Step - browser is open");
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is : "+projectPath);
        System.out.println("Project path is : "+projectPath+"/src/test/resources/Drivers/chromedriver.exe ");
        System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe ");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost:4200/");

        driver.findElement(By.id("exampleInputEmail1")).sendKeys("fan");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("nueva");
        driver.findElement(By.id("enter")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Event")).click();
        Thread.sleep(2000);
    }
    @Given("press the  button See Posts")
    public void press_the_button_See_Posts() {
        driver.findElement(By.id("seeposts")).click();
    }

    @When("choose a  publication")
    public void choose_a_publication() throws InterruptedException {
        Thread.sleep(2000);
    }

    @When("press white the button Show All Events")
    public void press_the_button_Show_All_Events() {
        driver.findElement(By.id("showeventsfanatic")).click();
    }
    @When("choose an event of its preference")
    public void choose_an_event_of_its_preference() throws InterruptedException{
        Thread.sleep(2000);
    }
    @When("press the button thumb up")
    public void press_the_button_thumb_up() {
        driver.findElement(By.id("thumbupevent")).click();
    }
    @When("press the button thumb down")
    public void press_the_button_thumb_down() {
        driver.findElement(By.id("thumbdownevent")).click();
    }
    @Then("it will be noticed that the fanatic likes the event")
    public void it_will_be_noticed_that_the_fanatic_likes_the_event() throws InterruptedException{
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }
    @Then("it will be noticed that the fanatic does not like the event")
    public void it_will_be_noticed_that_the_fanatic_does_not_like_the_event() throws InterruptedException{
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }

}
