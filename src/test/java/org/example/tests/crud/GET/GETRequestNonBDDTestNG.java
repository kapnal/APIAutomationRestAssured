package org.example.tests.crud.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
public class GETRequestNonBDDTestNG {

//CTRL+ALT+L -- To format the testng.xml
    @Test
    public void testGetAllBookingNegative(){

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/1629").log().all();
        r.when().get();
        r.then().log().all().statusCode(404);

    }

    @Test
    public void testGetAllBookingNegative2(){

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/abc").log().all();
        r.when().get();
        r.then().log().all().statusCode(404);

    }


    @Test (enabled = true)
    public void testGetAllBookingPositive() {

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/4027").log().all();
        r.when().log().all().get();
        r.then().log().all().statusCode(200);
    }

}
