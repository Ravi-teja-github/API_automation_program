package org.example.ex03_testNGexamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting016_TestNG_Groups_prod {

    @Test(groups = {"sanity", "QA", "prod", "P0"})
    public void sanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"REG", "P1"})
    public void RegRun(){
        System.out.println("REG");
        Assert.assertTrue(false);
    }

    @Test(groups = { "QA", "P2"})
    public void SmokeRun(){
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }

}
