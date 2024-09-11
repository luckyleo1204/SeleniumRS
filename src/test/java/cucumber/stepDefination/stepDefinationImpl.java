package cucumber.stepDefination;

import io.cucumber.java.en.Given;

public class stepDefinationImpl {

    @Given("^I landed on Ecommerce Page$")
    public void I_landed_on_Ecommerce_Page(){

    }

    // For Regular expresion should start with ^ and end with $, (.+) match all cases
    @Given("^I Logged in with username (.+) and password (.+)$")
    public void I_Logged_in_with_username_and_password(String uname, String pwd){


    }
}
