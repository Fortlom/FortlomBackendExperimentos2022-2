package com.example.fortlomisw.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ZFanAccountCustomizationSteps {
    WebDriver driver = null;

    @Given("go to the Configure section")
    public void enter_the_Configure_section() throws InterruptedException {
        System.out.println("Inside Step - browser is open");
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is : "+projectPath);
        System.out.println("Project path is : "+projectPath+"/src/test/resources/Drivers/chromedriver.exe ");
        System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe ");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost:4200/");

        driver.findElement(By.id("exampleInputEmail1")).sendKeys("tole");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("nueva");
        driver.findElement(By.id("enter")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.partialLinkText("Configure")).click();
        Thread.sleep(1000);
    }

    @When("fan click the + button")
    public void click_on_the_plus_button(){
        //driver.findElement(By.id("addbutton")).click();
    }

    @When("choose an image")
    public void choose_an_image_of_your_choice() throws InterruptedException{
        String projectPath = System.getProperty("user.dir");
        driver.findElement(By.id("my-file")).sendKeys( projectPath + "/src/test/java/com/example/fortlomisw/images/wallpaper joseph joestar.png");
    }

    @When("fill in the form fan data correctly")
    public void fill_in_the_form_data_correctly(){
        driver.findElement(By.id("inputname")).clear();
        driver.findElement(By.id("inputlastname")).clear();
        driver.findElement(By.id("inputemail")).clear();

        driver.findElement(By.id("inputname")).sendKeys("nametest");
        driver.findElement(By.id("inputlastname")).sendKeys("lastnametest");
        driver.findElement(By.id("inputemail")).sendKeys("emailtest@gmail.com");
    }

    @When("click on the Change fan Profile button")
    public void click_on_the_Change_Profile_button(){
        driver.findElement(By.id("buttonchange")).click();
    }

    @When("click on the Add button")
    public void you_click_on_the_Add_button(){
        driver.findElement(By.id("addgender")).click();
    }

    @Then("fan can see your image on your profile")
    public void you_can_see_your_image_on_your_profile() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }

    @Then("will be able to see the change in your profile name")
    public void will_be_able_to_see_your_change_in_your_profile_name() throws InterruptedException{
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }

    @Then("your art will be defined by a tag")
    public void your_art_will_be_defined_by_a_specific_tag() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
    @When("fill in the password fan data correctly")
    public void fill_in_the_password_fan_data_correctly() {
        driver.findElement(By.id("newpassword")).clear();
        driver.findElement(By.id("newpasswordagain")).clear();

        driver.findElement(By.id("newpassword")).sendKeys("nueva");
        driver.findElement(By.id("newpasswordagain")).sendKeys("nueva");

    }

    @When("click on the Update Password button")
    public void click_on_the_Update_Password_button() throws InterruptedException {
        driver.findElement(By.id("updatepassword")).click();
        Thread.sleep(2000);
    }

    @Then("your password is change")
    public void your_password_is_change() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().alert().getText().equals("password change");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        driver.close();
        driver.quit();

    }
}
