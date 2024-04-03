package org.example.tests.crud.practice;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GETRequestNonBDDTestNG {

    @Test
    public void testGetAllBookingNegative1(){

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/1629");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);

    }

    @Test
    public void testGetAllBookingPositive(){

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/-1");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);

    }

    @Test
    public void testGetAllBookingNegative(){

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/abc");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);

    }


}
