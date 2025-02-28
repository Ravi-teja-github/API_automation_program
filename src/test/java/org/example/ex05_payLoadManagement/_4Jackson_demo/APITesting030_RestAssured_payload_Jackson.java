package org.example.ex05_payLoadManagement._4Jackson_demo;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class APITesting030_RestAssured_payload_Jackson {

    RequestSpecification reqSpe;
    Response res;
    ValidatableResponse valres;

    @Test
    public  void test_Create_Booking_Positive(){
        // step1 - post
        // URL - Base URI + base Path
        // Header
        // Body
        // Auth -no

        // step2
        // prepare the payload (object -> JSON String)
        // send the request

        // Step3
        // validation Response (JSON String -> Objects)
        // Firstname,
        // Status Code
        // Time Response

        Booking booking=new Booking();
        booking.setFirstname("Ravi");
        booking.setLastname("Teja");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingdates=new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        // Java object -> json
        // .toJSON(object_ref)
        // .fromJSON(jsonString, ClassName.class)

        //Gson gson = new Gson();
       // String jsonStringBooking= gson.toJson(booking);
        //System.out.println(jsonStringBooking);

        ObjectMapper objectMapper;
        objectMapper = new ObjectMapper();
        String jsonStringBooking;
        try {
            jsonStringBooking = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(jsonStringBooking);



        reqSpe= RestAssured.given();
        reqSpe.baseUri("https://restful-booker.herokuapp.com");
        reqSpe.basePath("/booking/");
        reqSpe.contentType(ContentType.JSON);
        reqSpe.body(jsonStringBooking).log().all();

        Response response=reqSpe.when().post();
        String jsonResponseString= response.asString();

        valres= response.then().log().all();
        valres.statusCode(200);

        //Case1- extract()
       // String bookingid = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");
        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println("----------");

        //case2- JsonPath.getString("") JSON path extraction
        JsonPath jsonPath= new JsonPath(response.asString());
        String bookingid1 = jsonPath.getString("bookingid");
        String firstname1 = jsonPath.getString("booking.firstname");
        String lastname1 = jsonPath.getString("booking.lastname");
        System.out.println(bookingid1);
        System.out.println(firstname1);
        System.out.println(lastname1);
        System.out.println("----------");


        //Case 3 - De Serialisation - extractions
        //BookingResponse bookingResponse= gson.fromJson(jsonResponseString,BookingResponse.class);

        BookingResponse bookingResponse= null;
        try {
            bookingResponse = objectMapper.readValue(response.asString(), BookingResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(bookingResponse.getBookingid());
        System.out.println(bookingResponse.getBooking().getFirstname());
        System.out.println(bookingResponse.getBooking().getLastname());


        // AssertJ( 3rd- Lib to Assertions)

        assertThat(bookingResponse.getBooking()).isNotNull().isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Ravi").isNotEmpty().isNotNull().isNotBlank();
        assertThat(bookingResponse.getBooking().getLastname()).isEqualTo("Teja").isNotEmpty().isNotNull().isNotBlank();


    }


}
