package org.example.testng.listenerDemo;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class TC001 {

    @Test(groups = "sanity")
    public void tes1(){
        System.out.println("test1");
        Assert.assertTrue(false);
    }

    @Test(groups = "sanity")
    public void tes2(){
        System.out.println("test2");
        Assert.assertTrue(true);
    }

}
