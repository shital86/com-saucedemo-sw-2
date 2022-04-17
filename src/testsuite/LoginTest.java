package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before //setup browser
    public void setUp() {
        openBrowser(baseUrl);// Launch Url
    }

    @Test
    public void userSholdLoginSuccessfullyWithValid() {
        //Enter “standard_user” username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //Verify the text “PRODUCTS” text
        String expected = "PRODUCTS";
        WebElement actual = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String Actual = actual.getText();
        Assert.assertEquals("Verify the text PRODUCTS :", expected, Actual);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter “standard_user” username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //Verify that six products are displayed on page
        int expectedNumber = 6;
        List<WebElement> actualNumberElement = driver.findElements(By.className("inventory_item"));
        int actualNumber = actualNumberElement.size();
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
