package org.example.ex04_Assertions;


import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class APITesting024_AssertJ_Assertions {

    @Test
    public void test_hardAssertExample(){
        System.out.println("Start of the program");
        Integer bookingId= 1111;
        String firstname="Ravi";
        assertThat(bookingId).isNotNull().isNotZero().isPositive();
        assertThat(firstname).isEqualTo("Ravi").isNotEmpty().isNotNull().isNotBlank();
        System.out.println("End of the program");
    }



}
