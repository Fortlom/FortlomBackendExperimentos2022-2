package com.example.fortlomisw.StepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class CreateArtistForumSteps {

        WebDriver driver = null;
        String[] listName = new String[]{"forum1","forum2","forum3","forum4","forum5","forum6","forum7"};
        Random r = new Random();
        int indice;

        @Given("that the artist is in the Forum section")
        public void that_the_artist_is_in_the_Forum_section() throws InterruptedException{
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

        @When("click on the + button")
        public void click_on_the_plus_button(){
                driver.findElement(By.id("add")).click();
        }

        @When("correctly fill in the data")
        public void correctly_fill_in_the_data() throws InterruptedException{
                indice = r.nextInt(7);
                driver.findElement(By.id("forumname")).sendKeys(listName[indice]);
                driver.findElement(By.id("forumdescription")).sendKeys("forumdescription");
                Thread.sleep(2000);
        }

        @When("fill in the details")
        public void fill_in_the_details() throws InterruptedException{
                driver.findElement(By.id("forumdescription")).sendKeys("a description test");
                Thread.sleep(2000);
        }

        @When("the forum name is used")
        public void the_forum_name_is_used()throws InterruptedException{
                driver.findElement(By.id("forumname")).sendKeys("forumtest");
                Thread.sleep(2000);
        }

        @When("you have successfully created a forum")
        public void you_have_successfully_created_a_forum() throws InterruptedException{
                Thread.sleep(2000);
        }

        @When("click on Create")
        public void click_on_Create(){
                driver.findElement(By.id("createforum")).click();
        }

        @Then("message of your forum created successfully will appear")
        public void message_of_your_forum_created_successfully_will_appear() throws InterruptedException{
                Thread.sleep(2000);
                driver.switchTo().alert().accept();
                Thread.sleep(2000);
                driver.close();
                driver.quit();
        }

        @Then("message will appear your forum already exists")
        public void message_will_appear_your_forum_already_exists() throws InterruptedException{
                Thread.sleep(2000);
                driver.switchTo().alert().accept();
                Thread.sleep(2000);
                driver.close();
                driver.quit();
        }

        @Then("your forum will appear in the list")
        public void your_forum_will_appear_in_the_list() throws InterruptedException{
                Thread.sleep(2000);
                driver.close();
                driver.quit();
        }


}
