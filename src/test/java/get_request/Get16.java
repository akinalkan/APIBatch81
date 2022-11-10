package get_request;

import base_url.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static io.restassured.RestAssured.given;
import static java.lang.Integer.parseInt;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertEquals;

public class Get16 extends DummyRestApiBaseUrl {
    /*
           URL: https://dummy.restapiexample.com/api/v1/employees
           HTTP Request Method: GET Request
           Test Case: Type by using Gherkin Language
           Assert:  i) Status code is 200
                   ii) There are 24 employees
                  iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                   iv) The greatest age is 66
                    v) The name of the lowest age is "Tatyana Fitzpatrick"
                   vi) Total salary of all employees is 6,644,770
    */
/*
Given
https://dummy.restapiexample.com/api/v1/employees

When
    User sends a GET Request
Then
    i) Status code is 200
And
    ii) There are 24 employees
And
   iii) "Tiger Nixon" and "Garrett Winters" are among the employees
And
    iv) The greatest age is 66
And
     v) The name of the lowest age is "Tatyana Fitzpatrick"
And
    vi) Total salary of all employees is 6,644,770
 */

    @Test
    public void get16() {
        spec.pathParam("1", "employees");
        Response response = given().spec(spec).when().contentType(ContentType.JSON).get("/{1}");


        response.then().assertThat().statusCode(200).body("data", hasSize(24), "data.employee_name",hasItems("Tiger Nixon", "Garrett Winters"));

        JsonPath json = response.jsonPath();
        List<Integer> age = json.getList("data.employee_age");
        System.out.println("age = " + age);
        Collections.sort(age);
       String name1=response.jsonPath().getString("data.findAll{it.employee_age==" +age.get(0)+ "}.employee_name");
        System.out.println("En Genc Kisi = " + name1);
        assertEquals("[Tatyana Fitzpatrick]",name1);


        System.out.println("employees sayisi = " + age.size());
        List<String> name = json.getList("data.employee_name");
        System.out.println("name = " + name);

        List<Integer> salary = json.getList("data.employee_salary");
        System.out.println("salary = " + salary);
        int totalSalary =0;
        for (int w:salary) {
            totalSalary+=w;

        }
        System.out.println("totalSalary = " + totalSalary);
        assertEquals(6644770,totalSalary);

        int sumSalaries=salary.stream().reduce(0, Integer::sum);
        //System.out.println("sumSalaries = " + sumSalaries);


    }
}
