package RestAssured.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static java.util.Collections.swap;

public class jsonSchemaValidator {

    //Step 1: Get the response and
         //  generate schema using site: https://www.liquid-technologies.com/online-json-to-schema-converter
    //Step 2: Place the schema.json file under Target=>classes folder.
    // Step 3: Add the assert :  assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
    // Step 4 : Run and Validate the response.

    @Test
    public void Test_get() {
         given().get("https://reqres.in/api/users?page=2").
                 then().
                 assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
                 .statusCode(200)
                 .log().all();

    }



    @Test
    public void swapDemo(){

    }

    private void swapNumber(int a, int b) {
        int temp;
        temp=a;
        a=b;
        b=temp;

    }
}
