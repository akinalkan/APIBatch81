package get_request;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get02b extends ReqresBaseUrl {
    /*
   Given
       https://reqres.in/api/users/23
   When
       User send a GET Request to the url
   Then
       HTTP Status code should be 404
   And
       Status Line should be HTTP/1.1 404 Not Found
   And
       Server is "cloudflare"//-->headers dan ulasilir
   And
       Response body should be empty

*/

    @Test
    public void get02() {
        //First Step:Set the Url
        //Second Step:Set The Expected Data
        //Third Step:Send The Request and Get The Response
        //Four Step:Do Assertion


        //First Step:Set the Url
        spec.pathParams("first", "users", "second", 23);
        //Second Step:Set The Expected Data

        //Third Step:Send The Request and Get The Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //Four Step:Do Assertion
        assertEquals(404, response.statusCode());
        assertEquals("HTTP/1.1 404 Not Found", response.statusLine());
        assertEquals("cloudflare", response.getHeader("Server"));
        assertEquals(0, response.asString().replaceAll("[^A-Za-z0-9]", "").length());
        assertEquals(2, response.asString().replaceAll("\\s", "").length());

        response.
                then().
                statusCode(404).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 404 Not Found");


    }
}
