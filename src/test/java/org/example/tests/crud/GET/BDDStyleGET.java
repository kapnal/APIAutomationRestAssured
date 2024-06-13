package org.example.tests.crud.GET;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class BDDStyleGET {
    public static void main(String[] args) {

     String resp = RestAssured
                .given()
                .baseUri("https://api.zippopotam.us").basePath("/IN/560037")
                .when().log().all()
                .get()
                .then().log().all().statusCode(200).extract().response().asString();
        JsonPath js = new JsonPath(resp);
       String rsp=js.get("country");
        System.out.println(rsp);





    }
}
