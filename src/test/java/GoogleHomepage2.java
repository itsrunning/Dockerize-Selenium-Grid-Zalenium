import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class GoogleHomepage2 {


    @Test
    public void TestTwo() throws MalformedURLException {

        URL local = new URL("http://172.17.0.2:4244/wd/hub");//runs on docker 3
        WebDriver driver = new RemoteWebDriver(local, DesiredCapabilities.firefox());
        String baseUrl = "https://www.google.com/";
        System.out.println("This is instance 2");
        driver.get(baseUrl);
        driver.close();

        }


}
