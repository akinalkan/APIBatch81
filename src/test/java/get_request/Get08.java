package get_request;

import base_url.JsonplaceholderBaseUrl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Get08 extends JsonplaceholderBaseUrl {
    /*
        Given
           https://jsonplaceholder.typicode.com/todos/2
       When
           I send GET Request to the URL
       Then
           Status code is 200
           And "completed" is false
           And "userId" is 1
           And "title" is "quis ut nam facilis et officia qui"
           And header "Via" is "1.1 vegur"
           And header "Server" is "cloudflare"
           {
               "userId": 1,
               "id": 2,
               "title": "quis ut nam facilis et officia qui",
               "completed": false
           }
    */
//First Step:Set the Url
//Second Step:Set The Expected Data
//Third Step:Send The Request and Get The Response
//Four Step:Do Assertion
    @Test
    public void get07() {
        //First Step:Set the Url
        spec.pathParams("first", "todos", "second", 2);

        //Second Step:Set The Expected Data==>Payload
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 1);
        expectedData.put("id", 2);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("completed", false);
        System.out.println("expectedData = " + expectedData);
        //Third Step:Send The Request and Get The Response
        //Four Step:Do Assertion


    }
}
