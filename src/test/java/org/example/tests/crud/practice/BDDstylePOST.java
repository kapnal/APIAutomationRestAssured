package org.example.tests.crud.practice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class BDDstylePOST {

    @Test
    public void testBDDStylePOSTPositive(){

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON).log().all()
                .body(payload)
                .when().post()
                .then().log().all().statusCode(200);
    }
}
