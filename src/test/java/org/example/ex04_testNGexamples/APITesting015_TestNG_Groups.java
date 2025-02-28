package org.example.ex04_testNGexamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting015_TestNG_Groups {

    @Test(groups = {"sanity", "QA"})
    public void sanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"REG"})
    public void RegRun(){
        System.out.println("REG");
        Assert.assertTrue(false);
    }

    @Test(groups = { "QA"})
    public void SmokeRun(){
        System.out.println("Smoke");
        Assert.assertTrue(true);
    }

}
