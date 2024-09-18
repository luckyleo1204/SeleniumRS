package Grid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class googleTest {

    // Setup hub: java -jar selenium-server-4.24.0.jar hub
    // Node: java -jar selenium-server-4.24.0.jar node --detect-drivers true
    @Test public void gridDemo() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setBrowserName("chrome");
        WebDriver driver=new RemoteWebDriver(new URL(" http://192.168.29.88:4444"),caps);
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("Hello");
        driver.close();

    }
}
