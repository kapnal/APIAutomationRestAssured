package org.example.tests.crud.practice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDstylePOST {

    @Test
    public void testNonBDDStylePOSTPositive(){

        //Preparation of Request

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RequestSpecification r = RestAssured.given().log().all();

        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload);

        //Making Request

        Response response = r.when().post();

        //Validating Response

        ValidatableResponse validatableResponse= response.then().log().all();
        String responseString = response.asString();
        System.out.println(responseString);
        validatableResponse.statusCode(200);




    }
}
