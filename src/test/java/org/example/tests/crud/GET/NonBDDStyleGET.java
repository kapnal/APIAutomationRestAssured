package org.example.tests.crud.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyleGET {
    public static void main(String[] args) {

        // https://restful-booker.herokuapp.com/booking/4366

        RequestSpecification r = RestAssured.given();

        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/1883").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);



    }
}
