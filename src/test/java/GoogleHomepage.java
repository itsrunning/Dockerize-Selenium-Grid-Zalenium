import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GoogleHomepage {

    @Test
    public void TestOne() throws MalformedURLException {

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");


        URL local = new URL("http://172.17.0.2:4144/wd/hub"); //runs on chrome docker
      //  URL local = new URL("http://0.0.0.0:4444/wd/hub");
        WebDriver driver = new RemoteWebDriver(local, DesiredCapabilities.chrome());
        String baseUrl = "https://www.google.com/";
        System.out.println("This is instance 2");
        test.log(Status.INFO, "This step shows usage of log(status, details)");
        driver.get(baseUrl);
        driver.close();
        extent.flush();

    }
}
