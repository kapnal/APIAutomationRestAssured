package org.example.misc.gson.example;

import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Deserialize {

    @Test
    public void DeSerializationTest(){

        String jsonString ="{\n" +
                "    \"firstname\": \"Kapil\",\n" +
                "    \"lastname\": \"Nalwar\",\n" +
                "    \"totalprice\": 1568,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"additionalneeds\": \"Breakfast\",\n" +
                "    \"bookingDates\": {\n" +
                "        \"checkin\": \"2024-03-15\",\n" +
                "        \"checkout\": \"2024-03-17\"\n" +
                "    }\n" +
                "}";

        Gson gson = new Gson();
        Employee employeeobject = gson.fromJson(jsonString, Employee.class);

        String firstname = employeeobject.getFirstName();
        String lastname = employeeobject.getLastName();

        System.out.println(firstname);

//        Assert.assertEquals(firstname,"Kapil");

    }
}
