package org.example.tests.crud.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDStylePUT {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token = "7d60f7a31c150ff";

    @Test
    public void testPutREQUEST(){

        // url
        // auth - token , da829f2541bfd38 , headers - json
        // id - 3548
        // payload

        String payload = "{\n" +
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

            requestSpecification = RestAssured.given().log().all();
            requestSpecification.baseUri("https://restful-booker.herokuapp.com");
            requestSpecification.basePath("/booking/1104");
            requestSpecification.contentType(ContentType.JSON);
            requestSpecification.cookie("token",token);

            requestSpecification.body(payload).log().all();

            Response response = requestSpecification.when().put();

            validatableResponse = response.then().log().all();
            validatableResponse.statusCode(200);
            validatableResponse.body("firstname", Matchers.equalTo("Pramod"));
            validatableResponse.body("lastname",  Matchers.equalTo("Brown"));







    }
}
