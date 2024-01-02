package com.patil;//package com.patil;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.Response;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@QuarkusTestResource(WiremockTvProxy.class)
class TvSeriesResourceTest {

    @Test
    void get() {
        given()
                .when()
                .param("title", "girls")
                .get("/tvseries")
                .then()
                .body("id", equalTo(139))
                .body("name", equalTo("Girls"))
                .body("url", equalTo("https://www.tvmaze.com/shows/139/girls"))
                .body("language", equalTo("English"))
                .body("officialSite", equalTo("http://www.hbo.com/girls"))
                .statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    void getWithWireMock() {
        given()
                .when()
                .param("title", "girls")
                .get("/tvseries")
                .then()
                .body("id", equalTo(139))
                .body("name", equalTo("Girls"))
                .body("url", equalTo("https://www.tvmaze.com/shows/139/girls"))
                .body("language", equalTo("English"))
                .body("officialSite", equalTo("http://www.hbo.com/girls"))
                .statusCode(Response.Status.OK.getStatusCode());
    }
}