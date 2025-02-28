package org.example.ex05_payLoadManagement;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class APITesting026_RestAssured_payload_POJO {


    RequestSpecification reqSpe;
    Response res;
    ValidatableResponse valres;
    String token;
    Integer bookingId;

    @Test
    public void test_POST(){
     //  Map jsonBodyUsingMap=  new LinkedHashMap<>();
      // jsonBodyUsingMap.put("Firstname","Ravi");
       // jsonBodyUsingMap.put("lastname","Teja");
      //  jsonBodyUsingMap.put("totalprice",123);
      //  jsonBodyUsingMap.put("depositpaid",true);
//
      //  Map bookingDateMap=  new LinkedHashMap<>();
      //  bookingDateMap.put("Checkin", "2018-01-01");
      //  bookingDateMap.put("Checkout", "2019-01-01");

      //  jsonBodyUsingMap.put("bookingdates",bookingDateMap);
      //  jsonBodyUsingMap.put("additionalneeds","Breakfast");

      //  System.out.println(jsonBodyUsingMap);

        // TO CONVERT MAP TO JOSN (GSON AND JACKSON API )
        //this is map {Firstname=Ravi, lastname=Teja, totalprice=123, depositpaid=true, bookingdates={Checkin=2018-01-01, Checkout=2019-01-01}, additionalneeds=Breakfast}

        // we need to convert this in json

        //POJO

        Booking booking=new Booking();
        booking.setFirstname("Ravi");
        booking.setLastname("Teja");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingDates=new BookingDates();
        bookingDates.setCheckIn("2018-01-01");
        bookingDates.setCheckOut("2019-01-01");

        booking.setBookingDates(bookingDates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

       reqSpe= RestAssured.given();
       reqSpe.baseUri("https://restful-booker.herokuapp.com");
       reqSpe.basePath("/booking/");
       reqSpe.contentType(ContentType.JSON);
       reqSpe.log().all().body(booking);
       res= reqSpe.when().log().all().post();

        // get validatable response to perform validation
       valres= res.then().log().all().statusCode(500);

        //Rest Assured -> import org.hamcrest.matchers;
       // Matchers.equalto()
        valres.body("booking.firstname",Matchers.equalTo("Ravi"));
        valres.body("booking.lastname",Matchers.equalTo("Teja"));
        valres.body("booking.depositpaid",Matchers.equalTo(true));
        valres.body("bookingid",Matchers.notNullValue());

        // TestNG Assertions  -

        // SoftAssert vs
        // HardAssert -
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.


        bookingId = res.then().extract().path("bookingid");
        String firstname = res.then().extract().path("booking.firstname");
        String lastname = res.then().extract().path("booking.lastname");


        // TestNG Assertions

        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname,"Ravi");
        Assert.assertEquals(lastname,"Teja");


        // AssertJ( 3rd- Lib to Assertions)

        assertThat(bookingId).isNotNull().isNotZero().isPositive();
        assertThat(firstname).isEqualTo("Ravi").isNotEmpty().isNotNull().isNotBlank();



//        String s = ""; //Empty
//        String s2 = " "; //Blank

    }
}
