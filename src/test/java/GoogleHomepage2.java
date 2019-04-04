import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GoogleHomepage2 {

    WebDriver driver;
    ExtentTest test;
    ExtentReports extent;

    @BeforeTest()
    @Parameters({ "browserName" })
    public void setup(String browserName) throws MalformedURLException {

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("FFTest", "Google page opens in ff");

        URL local = new URL("http://172.17.0.2:4444/wd/hub");
        if(browserName.equalsIgnoreCase("Chrome")){
            driver = new RemoteWebDriver(local,DesiredCapabilities.chrome());
        }
        else{
            driver = new RemoteWebDriver(local,DesiredCapabilities.firefox());
        }
    }

    @Test
    public void TestTwo() throws InterruptedException {

//        System.setProperty("webdriver.chrome.driver","/Users/vidhyat/Desktop/Projects/Tests/chromedriver");
//        WebDriver driver = new ChromeDriver();
//
//        System.setProperty("webdriver.gecko.driver","/Users/vidhyat/Desktop/Projects/Tests/geckodriver 4");

//        WebDriver driver = new FirefoxDriver();

        String baseUrl = "https://www.google.com/";
        Thread.sleep(10000);
        driver.get(baseUrl);
        Thread.sleep(10000);
        System.out.println("This is firefox");
        test.log(Status.INFO, "page opened in firefox");

    }

    @AfterClass
    public void TearDown(){

            if(driver!=null){
                driver.quit();
            }
            extent.flush();
    }

}


