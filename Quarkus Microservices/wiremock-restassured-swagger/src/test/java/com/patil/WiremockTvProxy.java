package com.patil;//package com.patil;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import java.util.Collections;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WiremockTvProxy implements QuarkusTestResourceLifecycleManager {

    private WireMockServer wireMockServer;

    @Override
    public Map<String, String> start() {
        wireMockServer = new WireMockServer(8089);
        wireMockServer.start();
        configureFor(8089);

        stubFor(
                get(urlEqualTo("/singlesearch/shows?q=girls"))
                        .willReturn(
                                aResponse()
                                        .withHeader("Content-Type", "application/json")
                                        .withBody(
                                                "{\n" +
                                                        "  \"id\": 139,\n" +
                                                        "  \"name\": \"Girls\",\n" +
                                                        "  \"url\": \"https://www.tvmaze.com/shows/139/girls\",\n" +
                                                        "  \"language\": \"English\",\n" +
                                                        "  \"summary\": \"<p>This Emmy winning series is a comic look at the assorted humiliations and rare triumphs of a group of girls in their 20s.</p>\",\n" +
                                                        "  \"genres\": [\n" +
                                                        "    \"Drama\",\n" +
                                                        "    \"Romance\"\n" +
                                                        "  ],\n" +
                                                        "  \"officialSite\": \"http://www.hbo.com/girls\"\n" +
                                                        "}")));

        stubFor(
                get(urlMatching(".*"))
                        .atPriority(10)
                        .willReturn(aResponse().proxiedFrom("http://api.tvmaze.com")));

        return Collections.singletonMap("org.gs.TvSeriesProxy/mp-rest/url", wireMockServer.baseUrl());
    }

    @Override
    public void stop() {
        if (wireMockServer != null) {
            wireMockServer.stop();
        }
    }
}