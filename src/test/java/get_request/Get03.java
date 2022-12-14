package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class Get03 extends JsonplaceholderBaseUrl {
     /*
      Given
          https://jsonplaceholder.typicode.com/todos/23
      When
          User send GET Request to the URL
      Then
          HTTP Status Code should be 200
And
    Response format should be "application/json"
And
    "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
And
    "completed" is false
And
    "userId" is 2
   */

    @Test
    public void get01() {
        //Set the URL
        spec.pathParams("first","todos","second",23);//normalde URL https://jsonplaceholder.typicode.com seklinde
                                                                    //fakat https://jsonplaceholder.typicode.com/todos/23 bu sekilde
                                                                    //sonuna /todos/23 dinamik olarka eklemek icin bu sekilde yazilir
        //Expected Data
        //Send the request and Get Response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed",equalTo(false)).
                body("userId",equalTo(2));
    }
    @Test // 2. Yol Sadece 1 body içerisinde geçerli bir (Soft Assert). Ykarıdaki gibi heribiri için ayrı body yazmadık
    public void ikinciYontem(){

        spec.pathParams("first","todos","second",23);
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),"userId",equalTo(2));
    }
}
