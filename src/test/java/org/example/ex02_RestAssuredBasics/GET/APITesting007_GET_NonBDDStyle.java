package org.example.ex02_RestAssuredBasics.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting007_GET_NonBDDStyle {

    @Test
        public void Test_GET_Req_Positive() {
          // Rest Assured Interfaces
        String pincode = "560067";
        RequestSpecification r=RestAssured.given();
                r.baseUri("https://api.zippopotam.us/");
                r.basePath("/IN/" + pincode);
        Response response= r.when().log().all().get();
        ValidatableResponse vr= response.then().log().all().statusCode(200);
        }

    @Test
    public void Test_GET_Req_Negative() {
        // Rest Assured Interfaces
        String pincode= "-1";
        RequestSpecification r=RestAssured.given();
        r.baseUri("https://api.zippopotam.us/");
        r.basePath("/IN/" + pincode);
        Response response= r.when().log().all().get();
        ValidatableResponse vr= response.then().log().all().statusCode(404);
    }

}
