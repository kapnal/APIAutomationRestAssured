package org.example.tests.crud.practice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDPATCH {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token="a1086aa3a074fd3";

    @Test
    public void testPutREQUEST(){
        //id ,token,

        String payload = "{\n" +
                "    \"firstname\" : \"Kapil\",\n" +
                "    \"lastname\" : \"Nalwar\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/2723");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payload);

        Response response = requestSpecification.when().patch();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Kapil"));
        validatableResponse.body("lastname", Matchers.equalTo("Nalwar"));


    }
}
