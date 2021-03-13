package Modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public static void ValidCredentials() {
        //step 1
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //step 2
        driver.get("https://the-internet.herokuapp.com/login");

        //step 3: Fill username = tomsmith
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        //step 4: Fill password = SuperSecretPassword!
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //step 5: Click on Login button
        driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();

        //step 6: And the home page is appear
        String currentUrl = driver.getCurrentUrl();
        //Assert.assertEquals(currentUrl,"https://the-internet.herokuapp.com/secure"));
        Assert.assertTrue(currentUrl.contains("/secure"));
        }
    @Test (description = "invalid")
    public static void inValidCredentials() {
        //step 1
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //step 2
        driver.get("https://the-internet.herokuapp.com/login");

        //step 3: Fill username = tomsmith
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        //step 4: Fill password = SuperSecretPassword!
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword@");

        //step 5: Click on Login button
        driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();

        //step 6: And the home page is appear
        String currentUrl = driver.getCurrentUrl();
        //Assert.assertEquals(currentUrl,"https://the-internet.herokuapp.com/secure"));
        Assert.assertFalse(currentUrl.contains("/secure"));
    }
}
