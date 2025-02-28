package org.example.ex02_RestAssuredBasics.DELETE;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting013_DELETE_NonBDDStyle {

    RequestSpecification reqSpe;
    Response res;
    ValidatableResponse valres;

@Description("Verify the Delete Req Positive")
@Test
public void test_DELETE_NonBDDStyle(){

    String token= "0fe26590938d54d";
    String bookingid="683";

    reqSpe= RestAssured.given();
            reqSpe.baseUri("https://restful-booker.herokuapp.com");
            reqSpe.basePath("/booking/"+bookingid);
            reqSpe.contentType(ContentType.JSON);
            reqSpe.cookies("token",token);
            reqSpe.log().all();
    res= reqSpe.when().log().all().delete();
    valres= res.then().log().all().statusCode(201);

}

}
