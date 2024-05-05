package org.example.tests.crud.practice;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapPayload {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test
    public void testPOSTReq(){

        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap<>();
        Faker faker = new Faker();
        String name = faker.name().fullName();
        jsonBodyUsingMap.put("firstname",faker.name().firstName());
        jsonBodyUsingMap.put("lastname",faker.name().lastName());
        jsonBodyUsingMap.put("totalprice",3588);
        jsonBodyUsingMap.put("depositpaid",true);

        Map<String, Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin","2024-04-15");
        bookingDatesMap.put("checkout","2024-04-25");

        jsonBodyUsingMap.put("bookingdates",bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds","Breakfast");

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();

        Response response = requestSpecification.when().post();
        Integer bookingId = response.then().extract().path("bookingid");

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println("Your Booking Id is -> " + bookingId);













    }




}
