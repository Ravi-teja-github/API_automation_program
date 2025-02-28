package org.example.ex03_testNGexamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting021_TestNG_invocationcount {
    @Test
    public void test01(){
        Assert.assertTrue(true);
    }

    @Test(invocationCount= 3)
    public void test02(){
        Assert.assertTrue(true);
    }

    @Test
    public void test03(){
        Assert.assertTrue(true);
    }
}
