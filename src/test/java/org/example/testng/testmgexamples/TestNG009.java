package org.example.testng.testmgexamples;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG009 {

    @Test
    void testCase01(){
        // Assertion -  AR == ER
        // Two Types Assertions
        // Soft Assertion

        // Expected Result - pramod
        // Actual Result - Response? - pramod

//        SoftAssert s = new SoftAssert();
//        s.assertEquals(true,false,"True should not be equal to False");
//        System.out.println("Please execute me");
//        s.assertAll();

        // Hard Assertion
        Assert.assertEquals(true,false,"Failed");
        System.out.println("This will not print");

    }
}

