package org.example.ex02_RestAssuredBasics.PUT;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting011_PUT_NonBDDStyle {

    RequestSpecification reqSpe;
    Response res;
    ValidatableResponse valres;
// PUT
    // token, booking id
    // public void get_token(){}
   // public void get_bookingid(){}


@Description("Verify the PUT Req Positive")
@Test
public void test_PUT_NonBDDStyle(){

    String token= "3e12d3c2abf5c70";
    String bookingid="3741";
    String payload = "{\n" +
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
            reqSpe.basePath("/booking/"+bookingid);
            reqSpe.contentType(ContentType.JSON);
            reqSpe.cookies("token",token);
            reqSpe.log().all().body(payload);
    res= reqSpe.when().log().all().put();
    valres= res.then().log().all().statusCode(200);

}

}
