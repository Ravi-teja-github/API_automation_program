package org.example.ex04_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class APITesting025_RestAssured_TestNG_AssertJ_Assertions {


    RequestSpecification reqSpe;
    Response res;
    ValidatableResponse valres;
    String token;
    Integer bookingId;

    @Test
    public void test_POST(){
        String payload_POST= "{\n" +
                "    \"firstname\" : \"Ravi\",\n" +
                "    \"lastname\" : \"Teja\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";


        reqSpe= RestAssured.given();
        reqSpe.baseUri("https://restful-booker.herokuapp.com");
        reqSpe.basePath("/booking/");
        reqSpe.contentType(ContentType.JSON);
        reqSpe.log().all().body(payload_POST);
        res= reqSpe.when().log().all().post();

        // get validatable response to perform validation
        valres= res.then().log().all().statusCode(200);

        //Rest Assured -> import org.hamcrest.matchers;
       // Matchers.equalto()


        valres.body("bookingid",Matchers.notNullValue());
        valres.body("booking.firstname",Matchers.equalTo("Ravi"));
        valres.body("booking.lastname",Matchers.equalTo("Teja"));
        valres.body("booking.depositpaid",Matchers.equalTo(true));


        // TestNG Assertions
        /// SoftAssert vs HardAssert
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.

         bookingId = res.then().extract().path("bookingid");
         String firstname = res.then().extract().path("booking.firstname");
         String lastname = res.then().extract().path("booking.lastname");

         // TestNG Assertions

        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname,"Ravi");
        Assert.assertEquals(lastname,"Teja");

       // AssertJ (3rd- lib to assertions)
       // need to import static org.assertj.core.api.Assertions.assertThat;


        assertThat(bookingId).isNotNull().isNotZero().isPositive();
        assertThat(firstname).isEqualTo("Ravi").isNotEmpty().isNotNull().isNotBlank();

// String s= ""; ->Empty
// String s1= " "; ->Blank

    }
}
