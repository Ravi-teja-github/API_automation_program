package org.example.ex04_testNGexamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting013_TestNG {
    @BeforeTest
    public void getToken(){
        System.out.println("1");
    }

    @BeforeTest
    public void getBookingID(){
        System.out.println("2");
    }

    @Test
    public void PUT(){
        System.out.println("3");
    }

    @AfterTest
    public void closeAllThings(){
        System.out.println("close");
    }

}
