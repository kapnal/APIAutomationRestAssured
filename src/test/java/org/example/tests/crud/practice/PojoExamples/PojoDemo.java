package org.example.tests.crud.practice.PojoExamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PojoDemo {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test
    public void testPost(){

        Booking booking = new Booking();
        booking.setFirstname("Kapil");
        booking.setLastname("Nalwar");
        booking.setTotalprice(1500);
        booking.setDepositpaid(true);
        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-04-15");
        bookingDates.setCheckout("2024-04-18");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");


        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(booking).log().all();

        Response response = requestSpecification.when().post();
        Integer bookingId = response.then().extract().path("bookingid");

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println("Your Booking Id is -> " + bookingId);

    }

}
