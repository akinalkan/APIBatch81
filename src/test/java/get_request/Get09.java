package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get09 extends RestfulBaseUrl {//Nested map icerir
    /*
    Given
        https://restful-booker.herokuapp.com/booking/91
    When
        I send GET Request to the url
    Then
        Response body should be like that;
  {
    "firstname": "Sally",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2013-02-23",
        "checkout": "2014-10-23"
    },
    "additionalneeds": "Breakfast"
}
 */

    @Test
    public void get09() {
        //Set the Url
        spec.pathParams("first","booking","second",91);

        //Set The Expected Data
        Map<String,String> bookindatesMap= new HashMap<>();
        bookindatesMap.put("checkin","2013-02-23");
        bookindatesMap.put("checkout","2014-10-23");

        Map<String,Object> expectedData = new HashMap<>();//Json-->Java objesine donusturuldu
        expectedData.put("firstname","Sally");
        expectedData.put("lastname","Brown");
        expectedData.put("totalprice",111);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookindatesMap);
        expectedData.put("additionalneeds", "Breakfast");
        System.out.println("expectedData = " + expectedData);

    //Send The Request and Get The Response
       Response response=given().spec(spec).when().get("/{first}/{second}");
       response.prettyPrint();
       //Do Assertion
        Map<String,Object> actualData=response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
        assertEquals(expectedData.get("firstname"),expectedData.get("firstname"));
        assertEquals(expectedData.get("lastname"),expectedData.get("lastname"));
        assertEquals(expectedData.get("totalprice"),expectedData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"),expectedData.get("depositpaid"));
        assertEquals(bookindatesMap.get("checkin"), ((Map)(actualData.get("bookingdates"))).get("checkin"));
        //Key-Value ikilileri String-Object şeklinde olduğundan, Bookingdata value kısmını casting ile Map yaptık.
        assertEquals(bookindatesMap.get("checkout"), ((Map)(actualData.get("bookingdates"))).get("checkout"));
        assertEquals(expectedData.get("additionalneeds"),expectedData.get("additionalneeds"));



    }
}
