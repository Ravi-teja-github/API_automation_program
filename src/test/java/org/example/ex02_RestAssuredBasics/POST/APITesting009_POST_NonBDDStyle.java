package org.example.ex02_RestAssuredBasics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_POST_NonBDDStyle {

    RequestSpecification reqSpe;
    Response res;
    ValidatableResponse valres;

@Description("Verify the POST Req Positive")
@Test
public void test_POST_NonBDDStyle(){
    // TC > 100 -> Non BDD
    // TC < 100 -> BDD
    // url, body, header,

    String payload = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";

    reqSpe= RestAssured.given();
            reqSpe.baseUri("https://restful-booker.herokuapp.com");
            reqSpe.basePath("/auth");
            reqSpe.contentType(ContentType.JSON);
            reqSpe.log().all().body(payload);
    res= reqSpe.when().log().all().post();
    valres= res.then().log().all().statusCode(200);

}

}
