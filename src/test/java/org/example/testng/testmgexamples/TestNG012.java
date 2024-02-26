package org.example.testng.testmgexamples;

import org.testng.annotations.Test;

public class TestNG012 {
    @Test(groups = { "init" },priority = 1)
    public void getToken() {
        System.out.println("serverStartedOk");
    }

    @Test(groups = { "init" },priority = 2)
    public void getBookingID() {
        System.out.println("initEnvironment");
    }


    @Test(dependsOnGroups = { "init.*" })
    public void testPutReq() {
        System.out.println("Now I will run");
    }
}
