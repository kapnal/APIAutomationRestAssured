package org.example.tests.crud.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStyleGET {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
@Test
public void testNonBDDStyleGETPositive(){

        // https://restful-booker.herokuapp.com/booking/4366

    requestSpecification = RestAssured.given().log().all();
    requestSpecification.baseUri("https://restful-booker.herokuapp.com");
    requestSpecification.basePath("/booking/3658");

    Response response = requestSpecification.when().get();

   validatableResponse = response.then().log().all();
    validatableResponse.statusCode(200);


    }
}
