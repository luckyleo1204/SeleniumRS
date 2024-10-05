import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.*;
import utility.Retry;



import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FirstSelenium {
    public WebDriver driver;
/*  NoteS:
nodename	Selects all nodes with the name "nodename"
/	Selects from the root node
//	Selects nodes in the document from the current node that match the selection no matter where they are
.	Selects the current node
..	Selects the parent of the current node
@	Selects attributes
 */
    @BeforeClass
    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(20000));
    }

    @AfterClass
    public void teardown() {
       driver.quit();
    }

    @Test()
    public void practice1() throws IOException {
        driver.get("https://www.google.com");
        List<WebElement> list = driver.findElements(By.tagName("a"));
        for (WebElement i : list) {
            if (i.getAttribute("href") != null) {
                System.out.println("Link :" + i.getAttribute("href") + "is =>:" + linkStatus(new URL(i.getAttribute("href"))));
            }
        }
    }

    @Test()
    public void staticalDropdownDemo() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement dd = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
        dd.click();
        Thread.sleep(1000);
        Select select = new Select(dd);
        select.selectByValue("USD");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "USD");
        Thread.sleep(1000);
        select.selectByIndex(2);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "AED");
        Thread.sleep(1000);
        select.selectByVisibleText("INR");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "INR");
        Thread.sleep(1000);
    }

    @Test()
    public void advanceDropDown() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(5000);
        driver.findElement(By.id("divpaxinfo")).click();
        for (int i = 0; i < 2; i++) {
            Thread.sleep(1000);
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "3 Adult");
        driver.findElement(By.id("btnclosepaxoption")).click();

    }

    @Test()
    public void dynamicDropDown() throws InterruptedException {
        driver.get("https://www.spicejet.com/");
        Thread.sleep(20000);
        driver.findElement(By.xpath("//div[text()='From']")).click();
        driver.findElement(By.xpath("//div[text()='BLR']")).click();
        Thread.sleep(5000);
        //driver.findElement(By.xpath("//div[text()='To']")).click();
        Thread.sleep(1000);
        //Parent Child Relation ship way of identifying elements.
        driver.findElement(By.xpath("//div[@class=\"css-1dbjc4n r-knv0ih r-1k1q3bj r-ql8eny r-1dqxon3\"] //div[text()='MAA']")).click();
        // driver.findElement(By.xpath("//div[text()='MAA']")).click();
        Thread.sleep(1000);
    }

    @Test()
    public void autoSuggestDropDown() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(2000);
        driver.findElement(By.id("autosuggest")).sendKeys("Ind");
        Thread.sleep(2000);
        List<WebElement> list = driver.findElements(By.id("ui-id-1"));
        for (WebElement li : list) {
            if (li.getText().equalsIgnoreCase("India")) {
                li.click();
            }
        }

    }

    @Test()
    public void calendearDemo() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name=\"ctl00$mainContent$view_date1\"]")).click();
        WebElement currentDate = driver.findElement(By.cssSelector(".ui-state-highlight"));
        String cdate = currentDate.getText();
        currentDate.click();
        Assert.assertEquals(cdate, "29");
    }

    @Test()
    public void checkEnabledorDisabled() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(2000);
        if (driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_rbtnl_Trip_0\"]")).isEnabled()) {
            driver.findElement(By.id("ctl00_mainContent_view_date2")).getAttribute("readonly").equalsIgnoreCase("readonly");
        }
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
            System.out.println("One way is selected");
        } else {
            System.out.println(" Round trip is selected");
        }
    }

    @Test()
    public void alertDemo() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(2000);
        driver.findElement(By.id("name")).sendKeys("Murali");
        driver.findElement(By.id("alertbtn")).click();
        Assert.assertTrue(driver.switchTo().alert().getText().contains("Murali"));
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
    }

    @Test()
    public void cartDemo() throws InterruptedException {
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);
        addItems(driver, itemsNeeded);

    }

    public static void addItems(WebDriver driver, String[] itemsNeeded) {

        int j = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size(); i++) {

//Brocolli - 1 Kg

//Brocolli,    1 kg

            String[] name = products.get(i).getText().split("-");

            String formattedName = name[0].trim();

//format it to get actual vegetable name

//convert array into array list for easy search

//  check whether name you extracted is present in arrayList or not-

            List itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formattedName)) {

                j++;

//click on Add to cart

                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if (j == itemsNeeded.length) {

                    break;

                }

            }

        }

    }

    @Test()
    public void actionDemo1() throws InterruptedException {
        driver.get("https://www.amazon.in/");
        Thread.sleep(2000);
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        Thread.sleep(2000);
        act.moveToElement(driver.findElement(By.id("nav-link-accountList"))).contextClick().build().perform(); //right click : contextClick()
        Thread.sleep(2000);
    }

    @Test()
    public void actionDemo2() throws InterruptedException, IOException {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector("a.blinkingText")).click();
        Thread.sleep(2000);
        String parent = driver.getWindowHandle();
        Set<String> wins = driver.getWindowHandles();
//        for (String i : wins) {
//            if (!driver.switchTo().window(i).equals(parent)) {
//                driver.switchTo().window(i);
//                System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
//            }
//
//        }

        Iterator<String> it = wins.iterator();
        String pa1 = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        driver.switchTo().window(pa1);
        driver.findElement(By.id("username")).sendKeys(email);
    }

    @Test()
    public void framesDemo() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");
        Thread.sleep(2000);
        System.out.println(driver.findElements(By.tagName("iframe")).size()); // find all the iframe on page
        // driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
        driver.switchTo().frame(0);
        driver.findElement(By.id("draggable")).click();
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement dest = driver.findElement(By.id("droppable"));

        Actions act = new Actions(driver);
        act.dragAndDrop(source, dest).build().perform();
        Thread.sleep(5000);
        driver.switchTo().defaultContent();
    }


    @Test()
    public void limitDriverScopeforFooter() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(2000);
        System.out.println(driver.findElements(By.tagName("a")).size());
        WebElement footer = driver.findElement(By.cssSelector(".gf-t")); // sub driver. all the footer links.
        System.out.println(footer.findElements(By.tagName("a")).size());
        // get the first section of the footer links.
        WebElement firstSectionofFooter = driver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]"));
        System.out.println(firstSectionofFooter.findElements(By.tagName("a")).size());
        //To Click on each link : keys.chord(Keys.CONTROL, Keys.ENTER);


    }

    @Test()
    public void caleanderUI() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
        Thread.sleep(1000);
        Set<String> wins = driver.getWindowHandles();
        Iterator<String> it = wins.iterator();
        String parent = it.next();
        String child = it.next();
        String year = "2030"; //value="2024"
        driver.switchTo().window(child);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value=\"2024\"]")).click();
        for (int i = 0; i < 6; i++) {
            driver.findElement(By.xpath("//button[text()='›']")).click();
        }
    }

    @Test(groups = "smoketest")
    public void caleanderUIDemo() {
        String monthNumber = "6";

        String date = "15";

        String year = "2027";

        String[] expectedList = {monthNumber, date, year};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();

        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();

        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();

        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();

        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber) - 1).click();

        driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();

        List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

        for (int i = 0; i < actualList.size(); i++) {

            System.out.println(actualList.get(i).getAttribute("value"));

            Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
        }
    }


    @Test( groups = "smoketest")
    public void JavaScriptExecutorDemo() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        Thread.sleep(2000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
    }

    @Test()
    public void webTable() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(2000);
        int total = 0;
        List<WebElement> list = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        for (WebElement i : list) {
            total += Integer.parseInt(i.getText());
        }
        System.out.println(Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim()));
        Assert.assertEquals(total, Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim()));
        System.out.println(total);

        // reterive the value from the field using javaScript.
        //String val="return documents.getElementById("\hiddentText").value;";
        //String text=(String) js.executeScript(val);

    }

    @Test()
    public void sslcertificateDemo() throws InterruptedException {
        //  ChromeOptions options=new ChromeOptions();
        //  options.setAcceptInsecureCerts(true);
        //driver = new ChromeDriver(options);
        // refer for https://developer.chrome.com/docs/chromedriver/capabilities, setting proxy,

        ChromeOptions options = new ChromeOptions();

// Add the WebDriver proxy capability.
//        Proxy proxy = new Proxy();
//        proxy.setHttpProxy("myhttpproxy:3337");
//        options.setCapability("proxy", proxy);

// Add a ChromeDriver-specific capability.
//        options.addExtensions(new File("/path/to/extension.crx"));
//        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://expired.badssl.com/");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());


    }

    @Test()
    public void getScreenShot() throws IOException {

        driver.get("https:/www.google.com");
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Personal\\RS_P1\\screenShot\\1.png"));

    }

    @Test()
    public void validateListisSortedornot() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> originalList = elements.stream().map(n -> n.getText()).collect(Collectors.toList());
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(originalList, sortedList);

        //print the price of Beans from the list.

        List<String> price = elements.stream().filter(n -> n.getText().contains("Beans")).map(n -> getPrice(n)).collect(Collectors.toList());
        price.forEach(s -> System.out.println(s));

    }

    @Test()
    public void paginationDemo() throws InterruptedException {
        //driver.get("https://rahulshettyacademy.com/greenkart/#/offers");
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        Thread.sleep(2000);

// click on column

        driver.findElement(By.xpath("//tr/th[1]")).click();


// capture all webelements into list

        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));


// capture text of all webelements into new(original) list

        List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());


// sort on the original list of step 3 -> sorted list


        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

// compare original list vs sorted list

        Assert.assertTrue(originalList.equals(sortedList));

        List<String> price;

// scan the name column with getText ->Beans->print the price of the Rice

        do {

            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

            price = rows.stream().filter(s -> s.getText().contains("Rice"))

                    .map(s -> getPriceVeggie(s)).collect(Collectors.toList());

            price.forEach(a -> System.out.println(a));

            if (price.size() < 1) {

                driver.findElement(By.cssSelector("[aria-label='Next']")).click();

            }

        } while (price.size() < 1);


    }

    private static String getPriceVeggie(WebElement s) {

// TODO Auto-generated method stub

        String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();


        return pricevalue;

    }


    @Test()
    public void searchDemo() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        Thread.sleep(2000);
        String item = "Rice";
        driver.findElement(By.id("search-field")).sendKeys(item);
        List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> filteredlist = items.stream().filter(s -> s.getText().contains(item)).collect(Collectors.toList());
        Assert.assertEquals(items.size(), filteredlist.size());
    }

    @Test()
    public void RelativeLocatorsDemo() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        Thread.sleep(2000);
        WebElement nameEditBox=driver.findElement(By.name("name"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

        WebElement dateofBirth=driver.findElement(By.xpath("//label[@for=\"dateofBirth\"]"));
        driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();

        WebElement checkboxLabel=driver.findElement(By.cssSelector(".form-check-label"));
        driver.findElement(with(By.tagName("input")).toLeftOf(checkboxLabel)).click();

        WebElement radiobutton=driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radiobutton)).getText());

    }

    @Test(retryAnalyzer = Retry.class)  //retry this test multiple times.
    public void multipleWindowsTabs() throws InterruptedException, IOException {
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        Thread.sleep(2000);
        driver.switchTo().newWindow((WindowType.TAB));
        Set<String> wins=driver.getWindowHandles();
        Iterator<String> it=wins.iterator();
        String parent=it.next();
        String child=it.next();
        driver.switchTo().window(child);
        driver.get("https://rahulshettyacademy.com");
        String courseName=driver.findElement(By.xpath("(//h2/a)[1]")).getText();
        driver.switchTo().window(parent);
        WebElement name= driver.findElement(By.name("name"));
        name.sendKeys(courseName);
        File file=name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("C://Personal//RS_P1//screenShot//2.png"));
        //get height and width of an element.
        System.out.println(name.getRect().getHeight());
        System.out.println(name.getRect().getWidth());


    }


    private String getPrice(WebElement n) {
        return n.findElement(By.xpath("following-sibling::td[1]")).getText();
    }


    private String linkStatus(URL url) throws IOException {
        String status = null;
        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
        connect.connect();
        return status = connect.getResponseMessage();
    }

    @Test
    public void getPlayerName() throws InterruptedException {
        driver.get("https://www.google.com/search?q=ind+vs+ban");
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//*[text()='376'])[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//*[text()='1st Inn'])[1]")).click();
        Thread.sleep(5000);
        driver.findElements(By.xpath("(//table[@class=\"imspo_tps__tb\"])[1]/tbody/tr/td[5]/span[text()>'1']/preceding::td[5]/table/tbody/tr/td/div/div"))
                .stream().map(n->n.getText()).forEach(System.out::println);

        }

        @Test(enabled = true)
        public void Actions_P1() throws InterruptedException {

        driver.get("https://www.browserstack.com/");
        Thread.sleep(5000);
        WebElement element=driver.findElement(By.xpath("//*[text()='Get started free']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(element).click();

        }

        @Test(enabled = true)
    public void Actions_p2() throws InterruptedException {
            driver.get("https://www.browserstack.com/");

((JavascriptExecutor) driver).executeScript("scroll(0,300)");

Actions ac = new Actions(driver);

            WebElement live= driver.findElement(By. cssSelector("div.product-cards-wrapper--click a[title='Live']"));
            ac.moveToElement(live).build().perform();

            Thread.sleep(3000);

            WebElement automate= driver.findElement(By.cssSelector("div.product-cards-wrapper--click a[title='App Automate']"));
            automate.click();

            Thread.sleep(2000);
        }


        @Test
    public void webTableDemo() throws InterruptedException {
        driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
        Thread.sleep(2000);
        List<WebElement> al=driver.findElements(By.xpath("//table[@class=\"dataTable\"]/tbody/tr/td[5]/font"));

        for(int i=0;i<al.size();i++){
            System.out.println(al.get(i).getText());
            System.out.println(al.get(i).findElement(By.xpath("//ancestor::tr/td[1]")).getText());
        }

        }

    }
