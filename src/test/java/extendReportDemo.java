import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class extendReportDemo {

    ExtentReports extentReporter;
    WebDriver driver;
    @BeforeTest
    public void initiate(){
        String path=System.getProperty("user.dir")+"\\Report\\"+"index.html";
        System.out.println(path);
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(path);
        extentSparkReporter.config().setReportName("Web Automation Results");
        extentSparkReporter.config().setDocumentTitle("Test Results");

        extentReporter=new ExtentReports();
        extentReporter.attachReporter(extentSparkReporter);
        extentReporter.setSystemInfo("Tester","Murali");
        extentReporter.getStats();

        }


    @Test
    public void demo(){
       ExtentTest test= extentReporter.createTest("Initial Demo");
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(20000));
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        driver.close();
        //test.fail("Result is not matching"); forcefully failing the test.
        extentReporter.flush();


    }
}
