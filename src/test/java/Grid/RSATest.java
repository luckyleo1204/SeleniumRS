package Grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class RSATest {

    @Test
    public void TestRediffmail() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.BROWSER_NAME, "firefox");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.29.88:4444"), caps);
        driver.get("http://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        driver.close();

    }

}

