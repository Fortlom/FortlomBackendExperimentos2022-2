package com.example.fortlomisw.StepDefinitions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class FraudReport {
    WebDriver driver = null;

    @Given("that the artist is on Posts section fraud")
    public void that_the_artist_is_on_Posts_section_fraud() throws InterruptedException {
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
        driver.findElement(By.partialLinkText("Posts")).click();

    }

    @When("press the button See Posts")
    public void press_the_button_See_Posts() {
        driver.findElement(By.id("seeposts")).click();
    }

    @When("there is a publication that seems incorrect to him")
    public void there_is_a_publication_that_seems_incorrect_to_him() throws InterruptedException{
        Thread.sleep(2000);
    }

    @When("press the button Flag Post")
    public void press_the_button_Flag_Post() {
        driver.findElement(By.id("buttonFlagPost")).click();
    }

    @Then("the report is created")
    public void the_report_is_created() throws InterruptedException{
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }

    @Given("that the artist is on Forum section")
    public void that_the_artist_is_on_Forum_section() throws InterruptedException {
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
        driver.findElement(By.partialLinkText("Forum")).click();

    }

    @When("enter a forum")
    public void enter_a_forum() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.id("enterforum")).click();
    }

    @When("there is a forum that seems incorrect to him")
    public void there_is_a_forum_that_seems_incorrect_to_him() throws InterruptedException{
        Thread.sleep(2000);
    }

    @When("press the button Flag Forum")
    public void press_the_button_Flag_Forum() {
        driver.findElement(By.id("buttonFlagPost")).click();
    }

    @When("there is a forum commentary that seems incorrect to him")
    public void there_is_a_forum_commentary_that_seems_incorrect_to_him() throws InterruptedException{
        Thread.sleep(2000);
    }

    @When("press the button Flag Forum Commentary")
    public void press_the_button_Flag_Forum_Commentary() {
        driver.findElement(By.id("buttonFlagForumCommentary")).click();
    }
}
