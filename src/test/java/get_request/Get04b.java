package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.*;

public class Get04b extends RestfulBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
    When
        User sends get request to the URL
    Then
        Status code is 200
And
   Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"

 */
    //First Step:Set the Url
    //Second Step:Set The Expected Data
    //Third Step:Send The Request and Get The Response
    //Four Step:Do Assertion

    /*
    pathParam--> yol parametresi
    queryParams--> sorgu parametresi
     */


    @Test
    public void get04() {
//Set the Url
        spec.pathParam("first", "booking").queryParams("firstname", "Almedin", "lastname", "Alikadic");

//Set The Expected Data

//Send The Request and Get The Response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

//Do Assertion
        assertEquals(200, response.statusCode());
        assertTrue(response.asString().contains(""));

    }

}