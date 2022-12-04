package com.codewithhades.quarkus.nativedockerbuild;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class GreetingsResourceTest {

    @Test
    void greetingsResourceIntegrationTest() {
        given().when().get("/api").then().statusCode(200);
    }

}