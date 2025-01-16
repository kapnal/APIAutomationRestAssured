package org.example.tests.crud.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStylePOST {
    @Test
    public void testNonBDDStylePOSTPositive(){

        // Pre Paration

        String payload = "{\n" +
                "        \"username\": \"admin\",\n" +
                "        \"password\": \"password123\"\n" +
                "}";

        RequestSpecification r = RestAssured.given().log().all();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload);

        // Making Req

        Response response = r.when().post();

        // Validation Part

        ValidatableResponse validatableResponse= response.then().log().all();
        String responseString = response.asString();
        System.out.println(responseString);
        validatableResponse.statusCode(200);

    }

    }
