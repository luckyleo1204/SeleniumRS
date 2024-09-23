package Grid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class RSATest {
 /*   What is Selenium Grid?
    Selenium Grid is a smart proxy server that makes it easy to run tests in parallel on multiple machines.

    // Setup hub: java -jar selenium-server-4.24.0.jar hub
// Node: java -jar selenium-server-4.24.0.jar node --detect-drivers true
    Start the Node in Same Machine where Hub is running
    java -jar <SeleniumJarname> node --detect-drivers true
            • Start the Node in different Physical Machine
    java -jar <SeleniumJarname> node --detect-drivers true -- publish-events tcp://<ipaddressofhub> --subscribe-events tcp:// <ipaddressofhub>
            • Check the Status of Grid with http://localhost:4444/
            • Create Multiple Selenium TestNG Tests with the ability of parallel run
• Run the Tests and see the magic of distributing tests across multiple Node machines*/

    @Test
    public void TestRediffmail() throws MalformedURLException {

        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setBrowserName("chrome");
        WebDriver driver=new RemoteWebDriver(new URL(" http://192.168.29.88:4444"),caps);
        driver.get("http://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        driver.close();

    }

}

