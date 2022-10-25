import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get03 extends JsonPlaceHolderBaseUrl {
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
        //i)  Set the URL,
        spec.pathParams("first", "todos", "second", 23);
        //ii) Set the expected Data (beklenen datanin olusturulmasi, post, put, patch)

        //iii) Type code to send request and Get Response (Talep gondermek icin kod yazimi)
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //iv) Do Assertion ()dogrulama yapmak
    }
}
