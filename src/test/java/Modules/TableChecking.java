package Modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import table.Person;

import java.util.List;
import java.util.stream.Collectors;

public class TableChecking {
    private static WebDriver driver;

    @BeforeMethod
    private void setup(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @Test
    static void maximumDuePerson(){
        List<WebElement> cells = driver.findElements(By.xpath("//table[@id='table1']//tr/td[4]"));

        List<String> dues = cells.stream().map(WebElement::getText).collect(Collectors.toList());

       float max = Float.parseFloat(dues.get(0).replace("$",""));
       int maxIndex = 0;

       for(int i=1; i<dues.size();i++){
           if(Float.parseFloat(dues.get(i).replace("$",""))>max){
               max = Float.parseFloat(dues.get(i).replace("$",""));
               maxIndex = i;
           }
        }
        String firstName = driver.findElement(By.xpath(String.format("//table[@id='table1']//tr[%s]/td[2]",maxIndex+1))).getText();
        String lastName = driver.findElement(By.xpath(String.format("//table[@id='table1']//tr[%s]/td[1]",maxIndex+1))).getText();
        Assert.assertEquals(String.format("%s %s",firstName,lastName),"Jason Doe");

    }

//    @Test
//    static validateMinimumDuePerson(){
//
//    }

    @AfterMethod
    static void tearDown(){
        Assert.assertTrue(driver.getCurrentUrl().contains("tables"));
        driver.quit();
    }
}
