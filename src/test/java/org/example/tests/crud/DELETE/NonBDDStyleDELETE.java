package org.example.tests.crud.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStyleDELETE {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token = "f70bb3827102ae2";
    @Test
    public void testDELETEREQUEST(){

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/3658");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        Response response = requestSpecification.when().delete();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);


    }
}
