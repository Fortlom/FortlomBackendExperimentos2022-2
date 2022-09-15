package com.example.fortlomisw.StepDefinitions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class ArtistPublicationsSteps {
    WebDriver driver = null;

    @Given("that the artist is on your homepage")
    public void that_the_artist_is_on_your_homepage() throws InterruptedException {
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

    }
    @When("press the option Posts")
    public void press_the_option_Posts() {
        driver.findElement(By.partialLinkText("Posts")).click();
    }
    @When("fill in everything correctly")
    public void fill_in_everything_correctly() throws InterruptedException {
        driver.findElement(By.id("setPost")).clear();
        driver.findElement(By.id("setPost")).sendKeys("En las últimas semanas he estado trabajando en mi nuevo albúm, sé que les va a encantar");
        Thread.sleep(2000);
    }
    @When("press the button Post")
    public void press_the_button_Post() throws InterruptedException{
        driver.findElement(By.id("buttonPost")).click();
        Thread.sleep(2000);
    }
    @When("press button Post")
    public void press_button_Post() throws InterruptedException{
        driver.findElement(By.id("buttonPost")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }
    @Then("the publication will be created successfully")
    public void the_publication_will_be_created_successfully() throws InterruptedException {
        driver.findElement(By.id("seeposts")).click();
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }

    @When("do not fill out the form")
    public void do_not_fill_out_the_form() {

    }

    @Then("an alert message will appear")
    public void an_alert_message_will_appear() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }

    @Given("that the artist is on Posts section")
    public void that_the_artist_is_on_Posts_section() throws InterruptedException {
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
    @When("is creating a publication")
    public void is_creating_a_publication() {
        driver.findElement(By.id("setPost")).clear();
        driver.findElement(By.id("setPost")).sendKeys("En las últimas semanas he estado trabajando en mi nuevo albúm, sé que les va a encantar");
    }

    @When("press the clip")
    public void press_the_clip() throws InterruptedException {
        driver.findElement(By.id("buttonClip")).click();
        Thread.sleep(1000);
    }

    @When("select images")
    public void select_images() throws InterruptedException {
        String projectPath = System.getProperty("user.dir");
        driver.findElement(By.id("setimage")).clear();
        driver.findElement(By.id("setimage")).sendKeys(projectPath + "/src/test/java/com/example/fortlomisw/images/musicarock.jpg");
        Thread.sleep(3000);
    }

    @When("press the button Append")
    public void press_the_button_Append() throws InterruptedException  {
        driver.findElement(By.id("buttonAppend")).click();
        Thread.sleep(1500);
    }

    @Then("will be able to make a publication with images")
    public void will_be_able_to_make_a_publication_with_images() throws InterruptedException {
        driver.findElement(By.id("seeposts")).click();
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }
}
