package post_requests;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponseBodyPojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post04Pojo extends RestfulBaseUrl {
    /*
         Given
          1)  https://restful-booker.herokuapp.com/booking
          2)   {
                "firstname": "Ali",
                "lastname": "Can",
                "totalprice": 999,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-21",
                    "checkout": "2021-12-21"
                 }
                 "additionalneeds": "Breakfast"
             }
        When
 		    I send POST Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {
 		                            "bookingid": 16,
 		                            "booking" :{
                                        "firstname": "Ali",
                                        "lastname": "Can",
                                        "totalprice": 999,
                                        "depositpaid": true,
                                        "bookingdates": {
                                            "checkin": "2021-09-21",
                                            "checkout": "2021-12-21"
                                        }
                                        "additionalneeds": "Breakfast"
                                     }
                                  }
     */

    @Test
    public void post04Pojo() {
        spec.pathParam("first", "booking");

        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2021-09-21", "2021-12-21");
        BookingPojo expectedData = new BookingPojo("Ali", "Can", 999, true, bookingDatesPojo, "Breakfast with Dragon Juice");
        System.out.println("expectedData = " + expectedData);

        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();


        BookingResponseBodyPojo actualData=response.as(BookingResponseBodyPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getFirstname(),actualData.getBookingname().getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getBookingname().getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getBookingname().getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getBookingname().getDepositpaid());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getBookingname().getAdditionalneeds());
        assertEquals(bookingDatesPojo.getCheckin(),actualData.getBookingname().getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(),actualData.getBookingname().getBookingdates().getCheckout());



    }
}