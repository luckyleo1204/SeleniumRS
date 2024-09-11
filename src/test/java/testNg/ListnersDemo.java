package testNg;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//ITestListner
public class ListnersDemo implements ITestListener {

    @Override
    public void onTestStart(ITestResult result){
        System.out.println("Test started");
    }

//    @Override
//    public void onTestFinish(ITestResult result){
//
//    }


    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed!!!!!!" + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    @Override
    public boolean isEnabled() {
        return ITestListener.super.isEnabled();
    }

    @Override
    public void onTestFailure(ITestResult result){

    }
    @Override
    public void onTestSkipped(ITestResult result){

    }
}
