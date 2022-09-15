package com.example.fortlomisw.StepDefinitions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
public class LinkingPlatformsSteps {

    WebDriver driver = null;
    int number=0;

    @Given("that the artist is in the configuration section")
    public void that_the_artist_is_in_the_configuration_section() throws InterruptedException {
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
        driver.findElement(By.partialLinkText("Configure")).click();
    }
    @When("press the option to link with Facebook")
    public void press_the_option_to_link_with_Facebook() {
        driver.findElement(By.id("setaccounts")).click();
        driver.findElement(By.id("face")).click();
    }
    @When("put your link to your facebook page")
    public void put_your_link_to_your_facebook_page() {
        driver.findElement(By.id("setface")).clear();
        driver.findElement(By.id("setface")).sendKeys("https://www.facebook.com/PixarNosRechazo/");
        number=1;
    }
    @Then("established the link with the application")
    public void established_the_link_with_the_application() throws InterruptedException {
     if(number==1){ driver.findElement(By.id("updatefacebookaccount")).click();
         Thread.sleep(2000);
         driver.findElement(By.id("facelink")).click();
         Thread.sleep(2000);
         driver.close();
         driver.quit();}
     if (number==2){
         driver.findElement(By.id("updateinstgramaccount")).click();
         Thread.sleep(2000);
         driver.findElement(By.id("instalink")).click();
         Thread.sleep(2000);
         driver.close();
         driver.quit();}
     if(number==3){
         driver.findElement(By.id("updatetwitteraccount")).click();
         Thread.sleep(2000);
         driver.findElement(By.id("twitlink")).click();
         Thread.sleep(2000);
         driver.close();
         driver.quit();
     }



    }
    @When("press the option to link with Instagram")
    public void press_the_option_to_link_with_Instagram() {
        driver.findElement(By.id("setaccounts")).click();
        driver.findElement(By.id("insta")).click();
    }

    @When("put your link to your Instagram page")
    public void put_your_link_to_your_Instagram_page() {
        driver.findElement(By.id("setinsta")).clear();
        driver.findElement(By.id("setinsta")).sendKeys("https://www.instagram.com/labibliotecadeltemplojedi/");
        number=2;
    }
    @When("press the option to link with Twitter")
    public void press_the_option_to_link_with_Twitter() {
        driver.findElement(By.id("setaccounts")).click();
        driver.findElement(By.id("twitt")).click();
    }

    @When("put your link to your Twitter page")
    public void put_your_link_to_your_Twitter_page() {
        driver.findElement(By.id("settwitt")).clear();
        driver.findElement(By.id("settwitt")).sendKeys("https://twitter.com/hades5");
        number=3;
    }
}
