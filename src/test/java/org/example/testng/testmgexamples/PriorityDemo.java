package org.example.testng.testmgexamples;

import org.testng.annotations.Test;

public class PriorityDemo {

    @Test(priority = 2,groups = {"reg"})
    void demo1(){
        System.out.println("A");
    }

    @Test(priority = 1)
    void demo2(){
        System.out.println("B");
    }

    @Test
    void demo3(){           //if we don't add any priority then it will be the first priority so add to all priority
        System.out.println("C");
    }
}
