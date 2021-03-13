package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OpenCocCocBrowser {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Truc Truong\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");

    }

}
