package org.example.ex04_testNGexamples;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting018_TestNG_parameters {

    @Parameters("browser")
    @Test
    public void demo1(String value){
    System.out.println("Browser is " + value);
    //open the browser and select database
    if(value.equalsIgnoreCase("chrome")){
        System.out.println("Start Testing Chrome");
    }
    if (value.equalsIgnoreCase("firefox")){
        System.out.println("Start my Firefox");
    }
}
}
