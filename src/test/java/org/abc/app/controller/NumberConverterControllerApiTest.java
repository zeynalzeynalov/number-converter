package org.abc.app.controller;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

class NumberConverterControllerApiTest {

    @Test
    void checkStatus_shouldReturnApiRunning() {
        given()
                .baseUri("http://localhost:8080")
                .when()
                .get("/api/number-converter/status")
                .then()
                .statusCode(200)
                .body("data", equalTo("API is running."));
    }

    @Test
    void getTypes_shouldReturnServiceTypes() {
        given()
                .baseUri("http://localhost:8080")
                .when()
                .get("/api/number-converter/types")
                .then()
                .statusCode(200)
                .body("data", hasItems("DECIMAL_TO_ROMAN", "BINARY_TO_DECIMAL", "BINARY_TO_ROMAN"));
    }

    @Test
    void getLogs_shouldReturnLogs() {
        given()
                .baseUri("http://localhost:8080")
                .when()
                .get("/api/number-converter/logs")
                .then()
                .statusCode(200);
    }

    @Test
    void convert_shouldReturnConversionResult() {
        given()
                .baseUri("http://localhost:8080")
                .contentType("application/json")
                .body("{\"type\":\"DECIMAL_TO_ROMAN\",\"input\":\"123\"}")
                .when()
                .post("/api/number-converter/convert")
                .then()
                .statusCode(200)
                .body("data", equalTo("CXXIII"));
    }

    @Test
    void convert_withInvalidType_shouldReturnError() {
        given()
                .baseUri("http://localhost:8080")
                .contentType("application/json")
                .body("{\"type\":\"INVALID_TYPE\",\"input\":\"123\"}")
                .when()
                .post("/api/number-converter/convert")
                .then()
                .statusCode(400)
                .body("data", equalTo("Converter type INVALID_TYPE not found."));
    }
}