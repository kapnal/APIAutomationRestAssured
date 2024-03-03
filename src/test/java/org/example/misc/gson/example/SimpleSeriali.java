package org.example.misc.gson.example;

import com.google.gson.Gson;
import org.testng.annotations.Test;

public class SimpleSeriali {


    @Test
    public void test1(){

        Employee employee = new Employee();
        employee.setFirstName("Kapil");
        employee.setLastName("Nalwar");
        employee.setGender("M");
        employee.setAge(32);
        employee.setSalary(101500.00);
        employee.setMarried(true);

        Gson gson = new Gson();
        String jsonEmployee = gson.toJson(employee);

        System.out.println(jsonEmployee);



    }

}
