package org.example.testng.testmgexamples;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG004 {

    // PUT
    String token;
    Integer bookingID;

    public String getToken() {
        token = "123";
        return token;
    }
    @BeforeTest
    public void getTokenAndBookingID() {
        token = getToken();
        bookingID = 123;
    }

    @Test
    public void testPUTRUN(){
        System.out.println(token);
        System.out.println(bookingID);
    }

    @Test
    public void testPUTReq2() {
        System.out.println(token);
        System.out.println(bookingID);
    }

    @Test
    public void testPUTReq3() {
        System.out.println(token);
        System.out.println(bookingID);
    }

}
