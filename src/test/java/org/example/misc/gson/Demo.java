package org.example.misc.gson;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Demo {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    //Payload using the POJO Classes - plain old java object
@Test
public void testPost(){

    Booking bookings = new Booking();
    bookings.setFirstname("Kapil");
    bookings.setLastname("Nalwar");
    bookings.setTotalprice(1568);
    bookings.setDepositpaid(true);

    BookingDates bookingDates = new BookingDates();
    bookingDates.setCheckin("2024-03-15");
    bookingDates.setCheckout("2024-03-17");
    bookings.setBookingdates(bookingDates);
    bookings.setAdditionalneeds("Breakfast");

    requestSpecification= RestAssured.given();
    requestSpecification.baseUri("https://restful-booker.herokuapp.com");
    requestSpecification.basePath("/booking");
    requestSpecification.contentType(ContentType.JSON);
    requestSpecification.body(bookings).log().all();

    Response response = requestSpecification.when().post();
    Integer bookingId = response.then().extract().path("bookingid");


    validatableResponse = response.then().log().all();
    validatableResponse.statusCode(200);
    System.out.println("Your Booking Id is -> " + bookingId);


}



}
