package org.example.tests.crud.practice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Beforetestpostput {

    String token;
    int bookingId;
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @BeforeTest
    public void  getToken(){

        String payloadtoken = "{\n" +
                "        \"username\": \"admin\",\n" +
                "        \"password\": \"password123\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payloadtoken);

        Response response = requestSpecification.when().post();
        validatableResponse = response.then();
        token= response.then().log().all().extract().path("token");
        System.out.println(token);

    }

    @BeforeTest
    public void getBookingID(){

        String payloadbookingid = "{\n" +
                "    \"firstname\" : \"John\",\n" +
                "    \"lastname\" : \"Smith\",\n" +
                "    \"totalprice\" : 3588,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-02-25\",\n" +
                "        \"checkout\" : \"2024-02-27\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payloadbookingid);

        Response response = requestSpecification.when().post();
        validatableResponse = response.then();
        bookingId = response.then().log().all().extract().path("bookingid");
        Assert.assertNotNull(bookingId);
        System.out.println(bookingId);

    }

    @Test
    public void testNonBDDStylePUTReq(){

        String payloadput = "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);

        requestSpecification.body(payloadput);
        Response response = requestSpecification.when().put();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Pramod"));
        validatableResponse.body("lastname",  Matchers.equalTo("Brown"));

    }


}
