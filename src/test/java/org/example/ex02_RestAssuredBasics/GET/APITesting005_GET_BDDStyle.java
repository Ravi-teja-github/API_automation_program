package org.example.ex02_RestAssuredBasics.GET;

import io.restassured.RestAssured;

public class APITesting005_GET_BDDStyle {
    // Base URL
    public static void main(String[] args) {

        String pincode= "560067";
        RestAssured
                .given()
                  .baseUri("https://api.zippopotam.us/")
                  .basePath("/IN/"+pincode)
                .when()
                  .log().all().get()
                .then()
                  .log().all().statusCode(200);

        pincode = "-1";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("/IN/"+pincode)
                .when()
                .log().all().get()
                .then()
                .log().all().statusCode(200);

    }
}
