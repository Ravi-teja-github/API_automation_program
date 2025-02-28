package org.example.ex02_RestAssuredBasics.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting006_GET_BDDStyle {
    @Test
        public void Test_GET_Req_Positive() {
          String pincode = "560067";
          RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("/IN/" + pincode)
                .when()
                .log().all().get()
                .then()
                .log().all().statusCode(200);
        }

    @Test
        public void Test_GET_Req_Negative(){
            String pincode1= "-1";
            RestAssured
                    .given()
                    .baseUri("https://api.zippopotam.us/")
                    .basePath("/IN/"+pincode1)
                    .when()
                    .log().all().get()
                    .then()
                    .log().all().statusCode(404);

        }

}
