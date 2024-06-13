package org.example.misc.payloadmap;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PayloadUsingMap {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    @Test
    public void testPOSTReq(){

        //For payload insted of String we use Hashmap
        //Convert JSON payload - Map - it can contain further maps
        //Parent Map
        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap<>();
        Faker faker = new Faker();   //Faker methos used to generate dynamic random data
        String name = faker.name().fullName();
        jsonBodyUsingMap.put("firstname",faker.name().firstName());
        jsonBodyUsingMap.put("lastname",faker.name().lastName());
        jsonBodyUsingMap.put("totalprice", faker.random().nextInt(1000));
        jsonBodyUsingMap.put("depositpaid", faker.random().nextBoolean());

        //Child Map
        Map<String, Object> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin", "2024-03-15");
        bookingDatesMap.put("checkout", "2024-03-17");

        jsonBodyUsingMap.put("bookingdates", bookingDatesMap);  //Add child map to parent map
        jsonBodyUsingMap.put("additionalneeds","Breakfast");

        System.out.println(jsonBodyUsingMap);

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();


        Response response = requestSpecification.when().post();
        Integer bookingId = response.then().extract().path("bookingid");
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println(bookingId);




    }

}
