package com.example.fortlomisw.StepDefinitions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class CommentsPublicationsForumsFanaticSteps {

    WebDriver driver = null;

    @Given("that the fanatic is at the Publication section")
    public void that_the_fanatic_is_at_the_Publication_section() throws InterruptedException {
        System.out.println("Inside Step - browser is open");
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is : "+projectPath);
        System.out.println("Project path is : "+projectPath+"/src/test/resources/Drivers/chromedriver.exe ");
        System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe ");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost:4200/");
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("fan");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("nueva");
        driver.findElement(By.id("enter")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Publication")).click();
    }

    @Given("that the fanatic is at the Fanatic Forum section")
    public void that_the_fanatic_is_at_the_Fanatic_Forum_section() throws InterruptedException{
        System.out.println("Inside Step - browser is open");
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is : "+projectPath);
        System.out.println("Project path is : "+projectPath+"/src/test/resources/Drivers/chromedriver.exe ");
        System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe ");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost:4200/");

        driver.findElement(By.id("exampleInputEmail1")).sendKeys("fan");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("nueva");
        driver.findElement(By.id("enter")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Fanatic forum")).click();
        Thread.sleep(2000);
    }


    @When("press the blue button See Posts")
    public void press_the_button_See_Posts() {
        driver.findElement(By.id("seeposts")).click();
    }

    @When("press the button See")
    public void press_the_button_See() {
        driver.findElement(By.id("seecomments")).click();
    }

    @When("choose a publication")
    public void choose_a_publication() throws InterruptedException{
        Thread.sleep(2000);
    }

    @When("choose a forum of its preference")
    public void choose_a_forum_of_its_preference() throws InterruptedException{
        driver.findElement(By.id("enterforum")).click();
    }

    @When("write what it wants")
    public void write_what_it_wants() throws InterruptedException {
        driver.findElement(By.id("commentpost")).sendKeys("Input Testing");
        Thread.sleep(2000);
    }

    @When("write what it wants in the selected forum")
    public void write_what_it_wants_in_the_selected_forum() throws InterruptedException {
        driver.findElement(By.id("commentforum")).sendKeys("Input Testing");
        Thread.sleep(2000);
    }

    @When("press the button Post Comment")
    public void press_the_button_Post_Comment() {
        driver.findElement(By.id("postcomment")).click();
    }

    @When("press the button Accept")
    public void press_the_button_Accept() {
        driver.findElement(By.id("acceptcommentforum")).click();
    }







    @Then("the comment will be created successfully")
    public void the_comment_will_be_created_successfully() throws InterruptedException{
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }

    @Then("a message will show that the comment was created successfully")
    public void a_message_will_show_that_the_comment_was_created_successfully() throws InterruptedException{
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }

    @Then("the comments of the publication will be visualized")
    public void the_comments_of_the_publication_will_be_visualized() throws InterruptedException{
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }

}

