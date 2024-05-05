package org.example.tests.crud.practice.PojoExamples;

import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Deserialization {

    @Test
    public void DeSerialization(){

        String jsonStringEmployee = "{\n" +
                "  \"firstName\": \"Kapil\",\n" +
                "  \"lastName\": \"Nalwar\",\n" +
                "  \"gender\": \"M\",\n" +
                "  \"age\": 33,\n" +
                "  \"salary\": 101500.0,\n" +
                "  \"married\": true\n" +
                "}\n";

        Gson gson = new Gson();
        Employee employeeObject = gson.fromJson(jsonStringEmployee, Employee.class);

        String firstName = employeeObject.getFirstName();
        String lastName = employeeObject.getLastName();

        Assert.assertEquals(firstName,"Kapil");
        Assert.assertEquals(lastName,"Nalwar");



    }
}
