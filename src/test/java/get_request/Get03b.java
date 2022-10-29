package get_request;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get03b extends ReqresBaseUrl {
    /*
   Given
       https://reqres.in/api/users/2
   When
       User send GET Request to the URL
   Then
       HTTP Status Code should be 200
   And
       Response format should be "application/json"
   And
       "email" is "janet.weaver@reqres.in",
   And
       "first_name" is "Janet"
   And
       "last_name" is "Weaver"
   And
       "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
*/

    //First Step:Set the Url
    //Second Step:Set The Expected Data
    //Third Step:Send The Request and Get The Response
    //Four Step:Do Assertion

    @Test
    public void get_03() {
        String email = "janet.weaver@reqres.in";
        String first_name = "Janet";
        String last_name = "Weaver";
        String text = "To keep ReqRes free, contributions towards server costs are appreciated!";
        //Set the URL
        spec.pathParams("first", "users", "second", 2);
        //Send the Request
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //Assertions
        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("data.email", equalTo("janet.weaver@reqres.in"),
                        "data.first_name", equalTo("Janet"),
                        "data.last_name", equalTo("Weaver"),
                        "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

    }

}
