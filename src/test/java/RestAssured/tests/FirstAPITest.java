package RestAssured.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class FirstAPITest {


    @Test
    public void Test_get() {
        Response res = get("https://reqres.in/api/users?page=2");
        System.out.println(res.prettyPrint());
        System.out.println(res.getStatusCode());
        System.out.println(res.getBody().asString());
        System.out.println(res.getHeaders());
        System.out.println(res.getHeader("Content-Type"));

        Assert.assertEquals(res.getStatusCode(), 200);

    }

    @Test
    public void test2_get() {
        baseURI = "https://reqres.in/api";
        given().
                get("/users?page=2").
                then().
                statusCode(200).body("data.id[0]", equalTo(7)).log().all();
    }

    @Test
    public void test3_get(){
        baseURI = "https://reqres.in/api";
        given().get("/users?page=2").
                then().statusCode(200).body("data.first_name[1]",equalTo("Lindsay")).log().all();
    }

    @Test
    public void test4_get(){
        when().get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("page",equalTo(2))
                .log().all();
    }


    @Test
    public void test4_post(){
        baseURI = "https://reqres.in/api";
        // First Method.
//        Map<String, Object> map=new HashMap<>();
//        map.put("name","Murali");
//        map.put("job","Software Engineer");
//
//        JSONObject jsObject=new JSONObject(map);
//        System.out.println(jsObject.toJSONString());

        // Second Method.
        JSONObject request=new JSONObject();
        request.put("name","Murali1");
        request.put("job","Software Engineer");

       Response res= given().
                     header("Content-Type","application/json")
                    .contentType("application/json")
                    .accept(ContentType.JSON)
                    .body(request.toJSONString()).
               when().
                    post("/users");
        System.out.println(res.statusCode());
        System.out.println(res.prettyPrint());
//
//       String id=res.body().jsonPath().getString("id");
//        System.out.println(id);
//         given().get("/users/"+id).then().body("data.first_name",equalTo("Murali1")).log().all();


    }

    @Test
    public void test5_put(){
        baseURI = "https://reqres.in/api";
        JSONObject request=new JSONObject();
        request.put("name","Murali1");
        request.put("job","Software Engineer");
        Response res= given().
                header("Content-Type","application/json")
                .contentType("application/json")
                .accept(ContentType.JSON)
                .body(request.toJSONString()).
                when().
                put("/users/2");
        System.out.println(res.statusCode());
        System.out.println(res.prettyPrint());
    }

    @Test
    public void test6_Patch(){
        baseURI = "https://reqres.in/api";
        JSONObject request=new JSONObject();
        request.put("name","Murali5");
        Response res= given().
                header("Content-Type","application/json")
                .contentType("application/json")
                .accept(ContentType.JSON)
                .body(request.toJSONString()).
                when().
                patch("/users/2");
        System.out.println(res.statusCode());
        System.out.println(res.prettyPrint());
    }

    @Test
    public void test6_Delete(){
        baseURI = "https://reqres.in/api";
         Response res= given().
                header("Content-Type","application/json")
                .contentType("application/json")
                .accept(ContentType.JSON)
                .when().
                delete("/users/2");
        System.out.println(res.statusCode());
        System.out.println(res.prettyPrint());
    }

    @Test
    public void internalServer_get(){
        baseURI = "http://localhost:3000/Users";
        given().get().then().log().all();
    }

    @Test
    public void internalServer_post(){
        baseURI = "http://localhost:3000/";

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("FirstName","Johny");
        jsonObject.put("LastName","Mason");
        jsonObject.put("Subject", 2);
        jsonObject.put("id",4);

        given()
                .body(jsonObject.toJSONString())
                .when()
                .post("Users")
                .then().log().all();

    }

}