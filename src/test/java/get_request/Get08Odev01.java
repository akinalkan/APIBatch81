package get_request;

import base_url.AutomationExerciseBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get08Odev01 extends AutomationExerciseBaseUrl {
/*
Given
    https://automationexercise.com/api/productsList
When
    User sends a GET Request to the url
Then
    HTTP Status Code should be 200
And
    Content Type should be "text/html; charset=utf-8"
And
    Status Line should be HTTP/1.1 200 OK
And
     There must be 12 Women, 9 Men, 13 Kids usertype in products
  */
    //Not: JsonPath kullanınız...


    //First Step:Set the Url
    //Second Step:Set The Expected Data
    //Third Step:Send The Request and Get The Response
    //Four Step:Do Assertion


    @Test
    public void get08Odev01() {
        //First Step:Set the Url
        spec.pathParam("first", "productsList");

        Response response = given().spec(spec).when().get("/{first}");



        //Assertions
        response.then().
                statusCode(200).
                contentType("text/html; charset=utf-8").
                statusLine("HTTP/1.1 200 OK");

        JsonPath json = response.jsonPath();

        // There must be 12 Women, 9 Men, 13 Kids usertype in products
        List<String> women = json.getList("products.category.usertype.findAll{it.usertype=='Women'}.usertype");
        List<String> men = json.getList("products.category.usertype.findAll{it.usertype=='Men'}.usertype");
        List<String> kids = json.getList("products.category.usertype.findAll{it.usertype=='Kids'}.usertype");

        assertEquals(12, women.size());
        assertEquals(9, men.size());
        assertEquals(13, kids.size());

    }
}
