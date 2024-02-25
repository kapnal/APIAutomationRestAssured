package org.example.tests.crud.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDStylePATCH {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token = "7d60f7a31c150ff";

    @Test
    public void testPatchRequest(){

        String payload ="{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        requestSpecification = RestAssured.given().log().all();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/1104");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payload).log().all();

       Response response = requestSpecification.when().patch();

       validatableResponse = response.then().log().all();
       validatableResponse.statusCode(200);
       validatableResponse.body("firstname", Matchers.equalTo("James"));
       validatableResponse.body("lastname",Matchers.equalTo("Brown"));













    }








}
