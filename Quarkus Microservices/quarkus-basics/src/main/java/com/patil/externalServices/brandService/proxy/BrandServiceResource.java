package com.patil.externalServices.brandService.proxy;

import com.patil.externalServices.brandService.entity.Brand;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/externalBrand")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BrandServiceResource {

    @RestClient
    BrandServiceProxy brandServiceProxy;

    @GET
    public Response getBrand() {
        return Response.ok(brandServiceProxy.getBrand()).build();
    }

    @POST
    public Response saveBrand(Brand brand) {
        return Response.ok(brandServiceProxy.saveBrand(brand)).build();
    }


    @PUT
    @Path("/{brand_name}")
    public Response updateBrand(@PathParam("brand_name") String brand_name, Brand brand) {
        return Response.ok(brandServiceProxy.updateBrand(brand_name,brand)).build();
    }

    @DELETE
    @Path("/{brand_name}")
    public Response deleteBrand(@PathParam("brand_name") String brand_name) {
     return Response.ok(brandServiceProxy.deleteBrand(brand_name)).build();
    }
}
