package com.example.fortlomisw.StepDefinitions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class ArtistCommentsSteps {

    WebDriver driver = null;

    @Given("that the artist is in the Posts section")
    public void that_the_artist_is_in_the_Posts_section() throws InterruptedException {
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
        Thread.sleep(2000);
    }

    @Given("the artist is in the Forum section")
    public void the_artist_is_in_the_Forum_section() throws InterruptedException{
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
        Thread.sleep(2000);
    }

    @When("hit the see Posts button")
    public void hit_the_see_Posts_button(){
        driver.findElement(By.id("seeposts")).click();
    }

    @When("choose a publication of its preference")
    public void choose_a_publication() throws InterruptedException{
        Thread.sleep(2000);
    }

    @When("write what you want")
    public void write_what_you_want() throws InterruptedException{
        driver.findElement(By.id("commentpost")).sendKeys("comment 1");
        Thread.sleep(2000);
    }

    @When("hit the Post Comment button")
    public void hit_the_Post_Comment_button(){
        driver.findElement(By.id("postcomment")).click();
    }

    @When("choose a forum of your liking")
    public void choose_a_forum_of_your_liking(){
        driver.findElement(By.id("enterforum")).click();
    }

    @When("write what you want in the chosen forum")
    public void write_what_you_want_in_the_chosen_forum() throws InterruptedException{
        driver.findElement(By.id("commentforum")).sendKeys("comment 1");
        Thread.sleep(2000);
    }

    @When("hit the OK button")
    public void hit_the_OK_button(){
        driver.findElement(By.id("acceptcommentforum")).click();
    }

    @When("hit the See button")
    public void hit_the_See_button() throws InterruptedException{
        driver.findElement(By.id("seecomments")).click();
        Thread.sleep(2000);
    }

    @Then("your comment will be created successfully")
    public void your_comment_will_be_created_successfully() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }

    @Then("will output a message that the comment was successfully created")
    public void will_output_a_message_that_the_comment_was_successfully_created() throws InterruptedException{
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }

    @Then("you can view the comments of the publication")
    public void you_can_view_the_comments_of_the_publication() throws InterruptedException{
        Thread.sleep(4000);
        driver.close();
        driver.quit();
    }


}
