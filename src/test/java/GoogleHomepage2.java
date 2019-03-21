import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GoogleHomepage2 {


    @Test
    public void TestTwo() throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver", "/Users/vidhyat/Desktop/Projects/Tests/chromedriver");
//        WebDriver driver = new ChromeDriver();

        URL local = new URL("http://172.17.0.2:4444/wd/hub");
        WebDriver driver = new RemoteWebDriver(local, DesiredCapabilities.chrome());
        String baseUrl = "https://www.google.com/";
        System.out.println("This is instance 2");
        driver.get(baseUrl);
        driver.close();

        }


}
