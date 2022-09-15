package com.example.fortlomisw.StepDefinitions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class FanReportingCapacitySteps {

    WebDriver driver = null;

    @Given("the fanatic is in the publication section")
    public void the_fanatic_is_in_the_publication_section() throws InterruptedException {
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
        Thread.sleep(1000);
        driver.findElement(By.partialLinkText("Publication")).click();
        Thread.sleep(1000);
    }

    @Given("is in the Fanatic forum section")
    public void the_fanatic_is_in_the_forum_section() throws InterruptedException {
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
        Thread.sleep(1000);
        driver.findElement(By.partialLinkText("Fanatic forum")).click();
        Thread.sleep(1000);
    }


    @When("click on the see posts button")
    public void click_on_the_see_posts_button(){
        driver.findElement(By.id("seeposts")).click();
    }

    @When("detect a profane publication")
    public void detect_a_profane_publication(){
        driver.findElement(By.id("post content description")).getText().equals("incorrect post Test");
    }
    @And("click on the flag button")
    public void click_on_the_flag_button(){
        driver.findElement(By.id("buttonFlagPost")).click();
    }

    @Then("the publication is reported")
    public void the_publication_is_reported() throws InterruptedException{
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }

    @And("check a forum")
    public void enter_a_forum() {
        driver.findElement(By.id("forumtitle")).getText().equals("prueba");


    }

    @When("detect a profane foro")
    public void detect_a_profane_foro(){
        driver.findElement(By.id("enterforum")).click();

    }

    @Then("the foro is reported")
    public void theForoIsReported() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
        driver.quit();

    }

    @When("detect a profane comment")
    public void detectAProfaneComment() {

        driver.findElement(By.id("enterforum")).click();
        driver.findElement(By.id("commenttitle")).getText().equals("Hey");
    }

    @Then("the comment is reported")
    public void theCommentIsReported() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }
}
