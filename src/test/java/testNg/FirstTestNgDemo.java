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

    @Test(dependsOnMethods = "demo")
    public void MobileDemo1(){
        System.out.println("hi");
    }

    @Test(dependsOnGroups = "smoketest")
    public void Mobiledemo2(){
        System.out.println("hi");
    }


    @Test(priority = 0)
    public void Seconddemo2(){
        System.out.println("hi");
    }
}
