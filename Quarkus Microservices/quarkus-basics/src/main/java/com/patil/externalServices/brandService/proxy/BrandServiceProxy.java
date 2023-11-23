package com.patil.externalServices.brandService.proxy;


import com.patil.externalServices.brandService.entity.Brand;
import jakarta.json.JsonArray;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/brand")
@RegisterRestClient(baseUri = "http://localhost:8082")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BrandServiceProxy {

    @GET
   public Response getBrand();
    @POST
    public  Response saveBrand(Brand brand);

    @PUT
    @Path("/{brand_name}")
    public Response updateBrand(@PathParam("brand_name") String brand_name, Brand brand);

    @DELETE
    @Path("/{brand_name}")
    public JsonArray deleteBrand(@PathParam("brand_name") String brand_name);

}
