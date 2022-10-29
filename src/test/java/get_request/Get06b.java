package get_request;

import base_url.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.testng.AssertJUnit.assertEquals;

public class Get06b extends ReqresBaseUrl {
/*
   Given
          https://reqres.in/api/unknown/
   When
        I send GET Request to the URL
   Then

        1)Status code is 200
        2)Print all pantone_values
        3)Print all ids greater than 3 on the console
          Assert that there are 3 ids greater than 3
        4)Print all names whose ids are less than 3 on the console
          Assert that the number of names whose ids are less than 3 is 2

          1)Durum kodu 200
          2)Tüm pantone_değerlerini yazdır
           3)Konsolda 3'ten büyük tüm kimlikleri yazdır 3'ten büyük 3 kimlik olduğunu iddia et
           4)Kimlikleri 3'ten küçük olan tüm adları konsolda
            yazdır kimlikleri 3'ten küçük olan isimler 2'dir
*/

    //First Step:Set the Url
    //Second Step:Set The Expected Data
    //Third Step:Send The Request and Get The Response
    //Four Step:Do Assertion


    @Test
    public void get06() {
        spec.pathParam("first","unknown");

        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();




       assertEquals(response.statusCode(), 200);
        JsonPath json= response.jsonPath();

        //2)Tüm pantone_değerlerini yazdır
        System.out.println(json.getList("data.pantone_value"));

        //System.out.println(json.getList("data.pantone_value").size());
        //System.out.println(json.getList("data.pantone_value").get(0));

        List<Integer> list=json.getList("data.pantone_value");
        for (int i = 0; i <list.size() ; i++) {
            System.out.println((i+1)+". data : "+list.get(i));
        }

        //3)Konsolda 3'ten büyük tüm kimlikleri yazdır 3'ten büyük 3 kimlik olduğunu iddia et
        List<Integer> ids=json.getList("data.findAll{it.id>3}.id");//findAll collection'in basladigi yerde kullanilir
        System.out.println("ids = " + ids);

        assertEquals(ids.size(), 3);

        /*
        4)Kimlikleri 3'ten küçük olan tüm adları konsolda
        yazdır kimlikleri 3'ten küçük olan isimler 2'dir
        */

        List<String> names=json.getList("data.findAll{it.id<3}.name");
        System.out.println("names = " + names);
        assertEquals(names.size(), 2);


    }
}
