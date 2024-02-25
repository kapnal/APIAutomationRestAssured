package org.example.tests.crud.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDStyleCreatebookingPOST {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    @Test
    public void testNonBDDStylecreatebookingPOSTPositive(){

        String payload = "{\n" +
                "    \"firstname\" : \"John\",\n" +
                "    \"lastname\" : \"Smith\",\n" +
                "    \"totalprice\" : 3588,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-02-25\",\n" +
                "        \"checkout\" : \"2024-02-27\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification= RestAssured.given().log().all();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload).log().all();

        Response response = requestSpecification.when().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("booking.firstname", Matchers.equalTo("John"));
        validatableResponse.body("booking.lastname",  Matchers.equalTo("Smith"));






    }

    }
