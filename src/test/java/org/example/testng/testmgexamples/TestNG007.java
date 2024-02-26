package org.example.testng.testmgexamples;

import org.testng.annotations.Test;

public class TestNG007 {

    @Test(priority = 1)
    public void t1(){
        System.out.println("1");
    }

    @Test(priority = 2)
    public void t2(){
        System.out.println("3");
    }

    @Test(priority = -3)          //Negative priority is the first
    public void t3(){
        System.out.println("2");
    }
}
