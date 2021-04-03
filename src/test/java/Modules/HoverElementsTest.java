package Modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.swing.SwingUtilities2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class HoverElementsTest {
    private static WebDriver driver;
    //lien quan den chuot va ban phim - khi tro vao thi thong tin cua nguoi dung se hien thi

    @BeforeMethod
    private void setup(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
    }

    @Test
    static void hoverAvatar1(){
        Actions mouse = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement avatar1 = driver.findElement(By.xpath("//div[@class='figure'][1]"));
        mouse
                .moveToElement(avatar1)
                .perform();
//su dung ham nay de cho dong test minh chay dung, neu khong co tc van co the pass
        String caption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='figure'][1]/div/h5"))).getText();

        Assert.assertEquals(caption,"name: user1");
        //System.out.println(caption);

    }

    @AfterMethod
    static void tearDown() {
        //Assert.assertTrue(driver.getCurrentUrl().contains("status_codes"));
        driver.quit();
    }

}
