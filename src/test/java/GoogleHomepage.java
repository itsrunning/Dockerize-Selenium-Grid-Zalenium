import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class GoogleHomepage {

    WebDriver driver;
    ExtentTest test;
    ExtentReports extent;

    @BeforeTest()
    @Parameters("browserName")
    public void setup(String browserName) throws MalformedURLException {

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("ChromeTest", "Google page opens in chrome");
        URL local = new URL("http://172.17.0.2:4444/wd/hub");

        if(browserName.equalsIgnoreCase("Chrome")){
            driver = new RemoteWebDriver(local,DesiredCapabilities.chrome());
        }
        else{
            driver = new RemoteWebDriver(local,DesiredCapabilities.firefox());
        }
    }


    @Test
    public void TestOne() throws InterruptedException {

        String baseUrl = "https://www.google.com/";
        Thread.sleep(10000);
        System.out.println("This is chrome");
        test.log(Status.INFO, "page opened in chrome");
        driver.get(baseUrl);
        driver.close();

    }

    @AfterClass
    public void TearDown(){

        if(driver!=null){
            driver.quit();
        }
        extent.flush();
    }


}
