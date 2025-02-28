package org.example.ex02_RestAssuredBasics.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting008_GET_NonBDDStyle_with_instance {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
        public void Test_GET_Req_Positive() {
          // Rest Assured Interfaces
        String pincode = "560067";
         r=RestAssured.given();
                r.baseUri("https://api.zippopotam.us/");
                r.basePath("/IN/" + pincode);
        response= r.when().log().all().get();
        vr= response.then().log().all().statusCode(200);
        }

    @Test
    public void Test_GET_Req_Negative() {
        // Rest Assured Interfaces
        String pincode1= "-1";
        r=RestAssured.given();
            r.baseUri("https://api.zippopotam.us/");
           r.basePath("/IN/" + pincode1);
        response= r.when().log().all().get();
        vr= response.then().log().all().statusCode(404);
    }

}
