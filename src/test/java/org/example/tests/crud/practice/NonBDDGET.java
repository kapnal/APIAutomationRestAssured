package org.example.tests.crud.practice;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDGET {
    public static void main(String[] args) {

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/1629");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);



    }

}
