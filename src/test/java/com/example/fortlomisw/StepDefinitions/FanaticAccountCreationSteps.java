package com.example.fortlomisw.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class FanaticAccountCreationSteps {
    WebDriver driver = null;
    String email= UUID.randomUUID().toString().replace("-", "").substring(0,20)+"@gmail.com";
    String password=UUID.randomUUID().toString().replace("-", "").substring(0,20);
    String Username=UUID.randomUUID().toString().replace("-", "").substring(0,20);
    String name=UUID.randomUUID().toString().replace("-", "").substring(0,20);
    String lastname=UUID.randomUUID().toString().replace("-", "").substring(0,20);
    @Given("the fan to enter the platform")
    public void the_fan_to_enter_the_platform() {
        System.out.println("Inside Step - browser is open");
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is : "+projectPath);
        System.out.println("Project path is : "+projectPath+"/src/test/resources/Drivers/chromedriver.exe ");
        System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe ");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost:4200/");
    }

    @When("you press “Sign up as a fan”")
    public void you_press_Sign_up_as_a_fan() {
        driver.findElement(By.partialLinkText("Register yourself as a fan")).click();
    }
    @When("complete the form with your fan data")
    public void complete_the_form_with_your_fan_data() throws InterruptedException {
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
        driver.findElement(By.id("exampleInputalias")).sendKeys(Username);
        Thread.sleep(2000);
    }
    @When("hit the button {string}")
    public void hit_the_button(String string) throws InterruptedException {
        driver.findElement(By.id("enter")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }
    @Then("your fan account was successfully created")
    public void your_fan_account_was_successfully_created() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);


        driver.close();
        driver.quit();
    }
    @When("fill out the form incorrectly")
    public void fill_out_the_form_incorrectly() throws InterruptedException {
        driver.findElement(By.id("exampleInputEmail1")).sendKeys(email);
        Thread.sleep(2000);
        driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.id("exampleInputUserName1")).sendKeys("fan");
        Thread.sleep(2000);
        driver.findElement(By.id("exampleInputName1")).sendKeys(name);
        Thread.sleep(2000);
        driver.findElement(By.id("exampleInputLastName1")).sendKeys(lastname);
        Thread.sleep(2000);
        driver.findElement(By.id("exampleInputalias")).sendKeys(Username);
        Thread.sleep(2000);
    }
    @Then("will display a message that your fan account was not created")
    public void will_display_a_message_that_your_fan_account_was_not_created() throws InterruptedException {

        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);


        driver.close();
        driver.quit();
    }

    @Given("already has a fan account created on the platform")
    public void already_has_a_fan_account_created_on_the_platform() {
        System.out.println("Email created:"+"fan");
        System.out.println("Password created:"+"nueva");
    }

    @When("you complete your corresponding data in the form")
    public void you_complete_your_corresponding_data_in_the_form() throws InterruptedException {
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("fan");
        Thread.sleep(2000);
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("nueva");
        Thread.sleep(2000);
    }
    @When("submit the “Enter” button")
    public void submit_the_Enter_button() {
        driver.findElement(By.id("enter")).sendKeys(Keys.ENTER);
    }

    @Then("enter the platform with the account created")
    public void enter_the_platform_with_the_account_created() throws InterruptedException {
        Thread.sleep(2000);
        driver.getPageSource().contains("Welcome Fanatics");
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }


}
