package testNg;

import org.testng.annotations.*;

public class FirstTestNgDemo {

    @BeforeTest
    public void beforeTestDemo(){
        System.out.println("Executing Before TEst");
    }

    @AfterTest
    public void AfterTestDemo(){
        System.out.println("Executing After TEst");
    }

    @BeforeSuite
    public void beforeSuiteDemo(){
        System.out.println("Executing before Suite start");
    }

    @AfterSuite
    public void afterSuiteDemo(){
        System.out.println("Executing After Suite start");
    }
    @Test(timeOut = 4000)
    public void demo(){
        System.out.println("hi");
    }

    @Test(groups = "smoketest")
    public void Seconddemo(){
        System.out.println("hi");
    }

    @Test()
    public void MobileDemo1(){
        System.out.println("hi");
    }

    @Test()
    public void Mobiledemo2(){
        System.out.println("hi");
    }


    @Test(dataProvider="testData")
    public void Seconddemo2(String uname, String pwd){
        System.out.println(uname);
        System.out.println(pwd);
    }


    @DataProvider(name = "testData")
    public Object[][] dataProvider(){
        Object[] [] obj=new Object[3][2];
        obj[0][0]="user0";
        obj[0][1]="pass0";

        obj[1][0]="user1";
        obj[1][1]="pass1";

        obj[2][0]="user2";
        obj[2][1]="pass2";
        return obj;



    }


    @Parameters({"url"})
    @Test
    public void parameterDemo(String param){
        System.out.println(param);
    }
}
