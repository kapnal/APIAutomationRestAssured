package org.example.tests.crud.practice;

import io.restassured.RestAssured;

public class BDDstyleGET {

    public static void main(String[] args) {

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking/2218")
                .when().log().all()
                .get()
                .then().log().all().statusCode(200);


    }
}
