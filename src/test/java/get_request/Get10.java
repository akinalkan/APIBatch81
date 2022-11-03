package get_request;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.GoRestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.testng.AssertJUnit.assertEquals;

public class Get10 extends GoRestBaseUrl {
    /*
  Given
      https://gorest.co.in/public/v1/users/2986
  When
      User send GET Request to the URL
  Then
      Status Code should be 200
  And
      Response body should be like
   {
  "meta": null,
  "data": {
        "id": 2986,
       "name": "Kanaka Jain",
       "email": "kanaka_jain@stark.net",
       "gender": "male",
       "status": "active"
           }
    }
*/
    @Test
    public void get10() {
        spec.pathParams("first", "users", "second", 2986);
        GoRestData obj = new GoRestData();
        Map<String, String> expectedData = obj.dataKeyMap("Navin Talwar", "navin_talwar@mclaughlin.name", "male", "inactive");
        Map<String, Object> expectedDataMap=obj.expectedDataMethod(null, expectedData);
        System.out.println("expectedDataMap = " + expectedDataMap);


        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        Map<String,Object> actualData=response.as(HashMap.class);  //Json data==>Map'e cevirildi
        System.out.println("actualData = " + actualData);
        assertEquals(expectedDataMap.get("meta"),actualData.get("meta"));
        assertEquals(expectedData.get("name"),((Map)(actualData.get("data"))).get("name"));
        assertEquals(expectedData.get("email"),((Map)(actualData.get("data"))).get("email"));
        assertEquals(expectedData.get("gender"),((Map)(actualData.get("data"))).get("gender"));
        assertEquals(expectedData.get("status"),((Map)(actualData.get("data"))).get("status"));

        assertEquals(200,response.statusCode());


    }
}
