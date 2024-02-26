package org.example.testng.testmgexamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import static org.assertj.core.api.Assertions.*;

public class TestNG003 {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token;

    @BeforeTest
    public void getToken(){
        String payload ="{\n" +
                "        \"username\": \"admin\",\n" +
                "        \"password\": \"password123\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);
        Response response = requestSpecification.when().post();
        validatableResponse = response.then();

        //Assertion 1 - Rest Assured Matchers (Hamcrest) - 1-2% Times we use
//        validatableResponse.body("token", Matchers.notNullValue());
//        token = response.then().log().all().extract().path("token");
//        System.out.println(token);

        //Assertion 2 - TestNG assertion
        token = response.then().log().all().extract().path("token");
        Assert.assertNotNull(token);
        System.out.println(token);

        //Assertion 3 - AssertJ
//        assertThat(token).isNotNull().isNotBlank().isNotEmpty();
//        System.out.println(token);

    }

    @Test
    public void testNonBDDStylePUTReq(){

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
        requestSpecification.basePath("/booking/425");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);

        requestSpecification.body(payload);

        Response response = requestSpecification.when().put();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Pramod"));
        validatableResponse.body("lastname",  Matchers.equalTo("Brown"));

    }

}


