package org.example.testng.testmgexamples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG014 {
    // Data Driven Testing -
    // Test - with multiple inputs
    // loginTest - > 100 of users
    // rEGSTIERATION - DDT

    // Data Provider - Test Data?

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                new Object[]{"admin1","password1"},
                new Object[]{"admin2","password2"},
                new Object[]{"admin3","password3"},
                new Object[]{"admin4","password4"},
                new Object[]{"admin5","password5"},
        };
    }
    @Test(dataProvider = "getData")
    public void loginTest(String username,String password){
        System.out.println(username);
        System.out.println(password);

    }
}
