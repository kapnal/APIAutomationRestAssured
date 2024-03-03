package org.example.testng.parallel;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainClass {

    @BeforeMethod
    public void beforeMethod(){
        long id = Thread.currentThread().getId();
        System.out.println("Befor test-method. Thread is: " + id + getClass().getSimpleName());
    }

    @Test
    public void testMethodsOne(){
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method One. Thread is: " + id + getClass().getSimpleName());
    }

    @Test
    public void testMethodsTwo(){
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Two. Thread is: " + id + getClass().getSimpleName());
    }

    @AfterMethod
    public void afterMethod(){
        long id = Thread.currentThread().getId();
        System.out.println("After test-method. Thread is: " + id + getClass().getSimpleName());
    }

}
