package org.example.misc.gson;

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

       //Prepare payload
        Faker faker = new Faker();
        Booking bookings = new Booking();
        String expectFirstName = faker.name().firstName();
        bookings.setFirstname(expectFirstName);
        bookings.setLastname("Nalwar");
        bookings.setTotalprice(1568);
        bookings.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-03-15");
        bookingDates.setCheckout("2024-03-17");
        bookings.setBookingdates(bookingDates);
        bookings.setAdditionalneeds("Breakfast");

        //Convert the bookins object -> to JSOn String (GSON)

        Gson gson = new Gson();
       String jsonStringbooking = gson.toJson(bookings);
        System.out.println(jsonStringbooking);

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStringbooking).log().all();

        Response response = requestSpecification.when().post();
        String jsonResponseString = response.asString();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //Validate the response (JSOn String to Object)

       BookingResponse bookingresponseobject = gson.fromJson(jsonResponseString,BookingResponse.class);

       //Assertion using AssertJ
        assertThat(bookingresponseobject.getBookingid()).isNotNull();
        assertThat(bookingresponseobject.getBooking().getFirstname()).isEqualTo(expectFirstName);

        Integer Bookingid = bookingresponseobject.getBookingid();
        System.out.println("Your Booking Id -> " + Bookingid);


    }

}
