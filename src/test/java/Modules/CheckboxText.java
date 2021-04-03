package Modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxText {
    @Test
    public static void ValidCheckboxsIsChecked() {
        //step 1
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //step 2
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //step 3
        check(driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")));
        //step 4
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).isSelected());
        //step 5
        uncheck(driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")));
        //step 6
        Assert.assertFalse(driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).isSelected());

    }
    private static void check(WebElement element){
        if (!element.isSelected()){
            element.click();
        }
    }
    private static void uncheck(WebElement element){
        if (element.isSelected()){
            element.click();
        }
    }
}
