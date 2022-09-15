package com.example.fortlomisw.StepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;

public class FollowArtistSteps {
    WebDriver driver = null;

    @Given("that the fanatic is at the Artist section")
    public void that_the_fanatic_is_at_the_Artist_section() throws InterruptedException{
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
        driver.findElement(By.partialLinkText("Artists")).click();
        Thread.sleep(2000);
    }

    @When("press the button follow")
    public void press_the_button_follow() {
        driver.findElement(By.id("followartistasfan")).click();
    }

    @When("press the button Unfollow")
    public void press_the_button_Unfollow() {
        driver.findElement(By.id("unfollowartistasfan")).click();
    }

    @When("select a number at the bar")
    public void select_a_number_at_the_bar() {
        driver.findElement(By.id("rateartist")).click();
    }

    @Then("the artist will be followed")
    public void the_artist_will_be_followed() throws InterruptedException{
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }

    @Then("the artist will no longer be followed")
    public void a_message_will_no_longer_be_followed() throws InterruptedException{
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }

    @Then("a message will show that the artist has been rated")
    public void a_message_will_show_that_the_artist_has_been_rated() throws InterruptedException{
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }
}
