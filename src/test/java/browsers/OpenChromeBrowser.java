package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OpenChromeBrowser {
    public static void main(String[] args) {//go tat: psvm
        //System.out.println("hello selenium");//go tat: sout

        // cach 1: set truc tiep .exe, tao folder driver/copy file .exe
        // (phai down driver tuong ung voi version cua browser. vo - cach nay chac an nhat nhung ton dung luong
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //cach 2: su dung thu vien cho webdriver, download https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/4.3.1
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();

        //cach 3: copy file .exe vao C/window/system32
        //WebDriver driver = new ChromeDriver();
        //set size window
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //di toi 1 trang web cu the
        //cach 1:
        driver.get("https://selenium.dev");
        //cach 2:
        //driver.navigate().to("https://kenh14.vn");
        //driver.get("https://google.com.vn");
        driver.navigate().to("https://google.com.vn");
        driver.navigate().back();

        driver.quit();

    }
}
