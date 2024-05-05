package org.example.tests.crud.practice.PojoExamples;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class PostReqTC {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    @Test
    public void testPositive(){

        Booking booking = new Booking();
        Faker faker = new Faker();
        String expectFirstName = faker.name().firstName();
        booking.setFirstname(expectFirstName);
        booking.setLastname("Nalwar");
        booking.setTotalprice(1500);
        booking.setDepositpaid(true);
        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-04-15");
        bookingDates.setCheckout("2024-04-18");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");

        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStringBooking).log().all();

        Response response = requestSpecification.when().post();
        String jsonResponseString = response.asString();
        Integer bookingId = response.then().extract().path("bookingid");
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

       BookingResponse bookingResponseObject = gson.fromJson(jsonResponseString,BookingResponse.class);
        assertThat(bookingResponseObject.getBookingid()).isNotNull();
        assertThat(bookingResponseObject.getBooking().getFirstname()).isEqualTo(expectFirstName);




    }
}
