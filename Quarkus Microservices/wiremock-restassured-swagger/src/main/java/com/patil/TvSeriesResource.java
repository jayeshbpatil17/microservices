package com.patil;

import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.ws.rs.GET;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/tvseries")
public class TvSeriesResource {

    @RestClient
    TvSeriesProxy proxy;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("title") String title) {
        TvSeries tvSeries = proxy.get(title);
        return Response.ok(tvSeries).build();
    }
}
