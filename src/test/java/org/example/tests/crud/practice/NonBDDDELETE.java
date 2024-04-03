package org.example.tests.crud.practice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDDELETE {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token="47df2ba4fda0ca5";

    @Test
    public void testPutREQUEST(){

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/415");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);

        Response response = requestSpecification.when().delete();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);


    }
}
