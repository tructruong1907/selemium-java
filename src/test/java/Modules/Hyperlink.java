package Modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Hyperlink {
    private static WebDriver driver;

    @BeforeMethod
    private void setup(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/status_codes");
    }
    @DataProvider
    static Object[][] pages(){
        return new Object[][]{
                new Object[]{"200"},
        };
    }

    @Test(dataProvider = "pages")
    static void navigatetoPage(String name){
        driver.findElement (By.linkText(name)).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(String.format("status_codes/%s",name)));
        driver.findElement(By.linkText("here")).click();

    }
    @AfterMethod
    static void tearDown(){
        Assert.assertTrue(driver.getCurrentUrl().contains("status_codes"));
        driver.quit();
    }
}
