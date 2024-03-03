package org.example.testng.ddtTask;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.testng.ddt.UtilExcel;
import org.testng.annotations.Test;

public class VWOLogin {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test(dataProvider = "getData", dataProviderClass = UtilExcelData.class)
    public void testLoginData(String username, String password, String remember, String recaptcha_response_field) {
//        System.out.println("UserName - " + username);
//        System.out.println("Password - " + password);
//        System.out.println("Remember - " + remember);
//        System.out.println("Recaptcha_Response_Field - " + recaptcha_response_field);

        String payload = "{\n" +
                "\n" +
                "  \"username\": \""+username+"\",\n" +
                "\n" +
                "  \"password\": \""+password+"\",\n" +
                "\n" +
                "  \"remember\": "+remember+",\n" +
                "\n" +
                "  \"recaptcha_response_field\": "+recaptcha_response_field+"\n" +
                "\n" +
                "}";

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://app.vwo.com");
        requestSpecification.basePath("/login");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload).log().all();

        Response response = requestSpecification.when().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);



    }


}
