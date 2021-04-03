package Modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptTest {
    private static WebDriver driver;

    @BeforeMethod
    private void setup(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    static void clickForJsAlert(){
        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();

        //todo: dismiss alert via click OK button
        WebDriverWait wait =new WebDriverWait(driver, 10);
        Assert.assertTrue(wait.until(ExpectedConditions.alertIsPresent())!=null);

        driver.switchTo().alert().accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,"You successfully clicked an alert");
    }

    @Test
    static void clickForJsPrompt(){
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();

        WebDriverWait wait =new WebDriverWait(driver, 10);
        Assert.assertTrue(wait.until(ExpectedConditions.alertIsPresent())!=null);

        driver.switchTo().alert().sendKeys("Hello baby");
        driver.switchTo().alert().accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,"You entered: Hello baby");
    }

    @AfterMethod
    static void tearDown() {
        //Assert.assertTrue(driver.getCurrentUrl().contains("status_codes"));
        driver.quit();
    }
}
