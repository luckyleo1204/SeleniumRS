import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ParallelTestWithMultiThread {

    WebDriver driver;

    @Test()
    public void testOnChromeWithBrowserStackUrl()
    {
       // System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.get("https://www.browserstack.com/");
        driver.manage().window().maximize();
        System.out.println("this is the test related to chrome browserstack homepage"+ " " +Thread.currentThread().getId());

    }

    @Test()
    public void testOnChromeWithBrowserStackSignUp()
    {
       // System.setProperty("webdriver.gecko.driver", ".\\Driver\\geckodriver.exe");
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.get("https://www.browserstack.com/users/sign_up");
        driver.manage().window().maximize();
        driver.findElement(By.id("user_full_name")).sendKeys("<name>");
        driver.findElement(By.id("user_email_login")).sendKeys("<login email id>");
        driver.findElement(By.id("user_password")).sendKeys("<password>");
        System.out.println("this is the test related to chrome browserstack login"+ " " +Thread.currentThread().getName());

    }
    @AfterClass
    public void close()
    {
        driver.quit();
    }
}
