package org.example.ex02_RestAssuredBasics.PATCH;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting012_PATCH_NonBDDStyle {

    RequestSpecification reqSpe;
    Response res;
    ValidatableResponse valres;
// PUT
    // token, booking id
    // public void get_token(){}
   // public void get_bookingid(){}


@Description("Verify the PATCH Req Positive")
@Test
public void test_PATCH_NonBDDStyle(){

    String token= "0fe26590938d54d";
    String bookingid="683";
    String payload = "{\n" +
            "    \"firstname\" : \"Ravi\",\n" +
            "    \"lastname\" : \"allu\",\n" +
            "}";

    reqSpe= RestAssured.given();
            reqSpe.baseUri("https://restful-booker.herokuapp.com");
            reqSpe.basePath("/booking/"+bookingid);
            reqSpe.contentType(ContentType.JSON);
            reqSpe.cookies("token",token);
            reqSpe.log().all().body(payload);
    res= reqSpe.when().log().all().patch();
    valres= res.then().log().all().statusCode(200);

}

}
