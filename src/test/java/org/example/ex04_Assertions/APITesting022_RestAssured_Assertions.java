package org.example.ex04_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;

public class APITesting022_RestAssured_Assertions {


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
        valres.body("booking.firstname",Matchers.equalTo("Ravi"));
        valres.body("booking.lastname",Matchers.equalTo("Teja"));
        valres.body("booking.depositpaid",Matchers.equalTo(true));
        valres.body("bookingid",Matchers.notNullValue());


    }
}
