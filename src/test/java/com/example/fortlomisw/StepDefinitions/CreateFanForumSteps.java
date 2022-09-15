package com.example.fortlomisw.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CreateFanForumSteps {
    WebDriver driver = null;
    String[] listName = new String[]{"forum1","forum2","forum3","forum4","forum5","forum6","forum7"};
    Random r = new Random();
    int indice;

    @Given("that the fanatic is in the Fanatic forum section")
    public void fanatic_is_in_the_Forum_section() throws InterruptedException {
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

    @When("fan click on the + button")
    public void click_on_add_button(){
        driver.findElement(By.id("add")).click();
    }

    @When("fan correctly fill data")
    public void correctly_fill_in_the_data() throws InterruptedException{
        indice = r.nextInt(7);
        driver.findElement(By.id("forumname")).sendKeys(listName[indice]);
        driver.findElement(By.id("forumdescription")).sendKeys("forumdescription");
        Thread.sleep(1000);
    }

    @When("fan click on Create")
    public void click_on_Create(){
        driver.findElement(By.id("createforum")).click();
    }

    @Then("message of \"your forum created successfully will appear\"")
    public void message_of_your_forum_created_successfully() throws InterruptedException{
        Thread.sleep(1000);
        driver.switchTo().alert().getText().equals("se creo su foro exitosamente");
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }

    @Then("message will appear \"this forum already exists\"")
    public void message_of_this_forum_already_exist() throws InterruptedException{
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }

    @When("fan fill in the details")
    public void fill_in_the_details() throws InterruptedException{
        driver.findElement(By.id("forumdescription")).sendKeys("a description test");
        Thread.sleep(1000);
    }

    @And("forum name is used")
    public void the_forum_name_is_used()throws InterruptedException{
        driver.findElement(By.id("forumname")).sendKeys("forumtestfan");
        Thread.sleep(1000);
    }

    @When("you have successfully created a fan forum")
    public void you_have_successfully_created_a_forum() throws InterruptedException{
        Thread.sleep(1000);
    }

    @Then("your new forum will appear in the list")
    public void your_forum_will_appear_in_the_list() throws InterruptedException{
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }

}
