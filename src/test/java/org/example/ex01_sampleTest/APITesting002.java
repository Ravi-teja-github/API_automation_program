package org.example.ex01_sampleTest;

import io.restassured.RestAssured;

public class APITesting002 {
    public static void main(String[] args) {
        // Gherkins syntax
        //Given -> pre req.- url, Headers. Auth, Body....
        //when -> HTTP methods? - GET/POST/PUT/PATCH. DELETE....
        //Then -> Validations -> 200 ok, firstname == Raviteja

        // Full url -> https://api.zippopotam.us/IN/560067
        // base url -> https://api.zippopotam.us
        // bath path -> IN/560067

        RestAssured
                .given()
                  .baseUri("https://api.zippopotam.us")
                  .basePath("IN/560067")
                .when()
                  .get()
                .then()
                  .log().all()
                  .statusCode(200);

    }
}
