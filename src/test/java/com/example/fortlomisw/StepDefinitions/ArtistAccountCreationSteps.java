package com.example.fortlomisw.StepDefinitions;
import java.util.concurrent.TimeUnit;
import java.util.UUID;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ArtistAccountCreationSteps {
    WebDriver driver = null;
    String email=UUID.randomUUID().toString().replace("-", "").substring(0,20)+"@gmail.com";
    String password=UUID.randomUUID().toString().replace("-", "").substring(0,20);
    String Username=UUID.randomUUID().toString().replace("-", "").substring(0,20);
    String name=UUID.randomUUID().toString().replace("-", "").substring(0,20);
    String lastname=UUID.randomUUID().toString().replace("-", "").substring(0,20);

    @Given("that the artist enters the platform")
    public void that_the_artist_enters_the_platform() throws InterruptedException {
        System.out.println("Inside Step - browser is open");
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is : "+projectPath);
        System.out.println("Project path is : "+projectPath+"/src/test/resources/Drivers/chromedriver.exe ");
        System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe ");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost:4200/");
    }



    @When("press “Register yourself as an Artist”")
    public void press_Register_yourself_as_an_Artist() {
        driver.findElement(By.partialLinkText("Register yourself as an artist")).click();
    }


    @When("complete the form with your data")
    public void complete_the_form_with_your_data() throws InterruptedException {
        driver.findElement(By.id("exampleInputEmail1")).sendKeys(email);
        Thread.sleep(2000);
        driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.id("exampleInputUserName1")).sendKeys(Username);
        Thread.sleep(2000);
        driver.findElement(By.id("exampleInputName1")).sendKeys(name);
        Thread.sleep(2000);
        driver.findElement(By.id("exampleInputLastName1")).sendKeys(lastname);
        Thread.sleep(2000);
    }


    @When("hit the “Register as Artist” button")
    public void hit_the_Register_as_Artist_button() throws InterruptedException {
        driver.findElement(By.id("enter")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }



    @Then("your account was successfully created")
    public void your_account_was_successfully_created() throws InterruptedException {
        String text = driver.switchTo().alert().getText();

        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);


        driver.close();
        driver.quit();

    }










    @When("incorrectly complete the form")
    public void incorrectly_complete_the_form() throws InterruptedException {
        driver.findElement(By.id("exampleInputEmail1")).sendKeys(email);
        Thread.sleep(2000);
        driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.id("exampleInputUserName1")).sendKeys("alianza");
        Thread.sleep(2000);
        driver.findElement(By.id("exampleInputName1")).sendKeys(name);
        Thread.sleep(2000);
        driver.findElement(By.id("exampleInputLastName1")).sendKeys(lastname);
        Thread.sleep(2000);
    }







    @Then("will display a message that your account was not created")
    public void will_display_a_message_that_your_account_was_not_created() throws InterruptedException {
        String text = driver.switchTo().alert().getText();

        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);


        driver.close();
        driver.quit();

    }







    @Given("already has an account created on the platform")
    public void already_has_an_account_created_on_the_platform() throws InterruptedException {
        System.out.println("Email created:"+"alianza");
        System.out.println("Password created:"+"nueva");
    }



    @When("complete your corresponding data in the form")
    public void complete_your_corresponding_data_in_the_form() throws InterruptedException {
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("alianza");
        Thread.sleep(2000);
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("nueva");
        Thread.sleep(2000);

    }



    @When("hit the “Enter” button")
    public void hit_the_Enter_button() throws InterruptedException {
        driver.findElement(By.id("enter")).sendKeys(Keys.ENTER);

    }



    @Then("will enter the platform with the account created")
    public void will_enter_the_platform_with_the_account_created() throws InterruptedException {
        Thread.sleep(2000);
        driver.getPageSource().contains("Welcome Artists");
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}
