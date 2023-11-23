package com.patil.resource;

import com.patil.entity.Brand;
import io.smallrye.faulttolerance.internal.FallbackMethod;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/brand")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BrandResource {

    List<Brand> brandList = new ArrayList<>();
    @GET
    @Fallback(fallbackMethod = "getError")
    public Response getBrand(){
        return  Response.ok(brandList).build();
    }

    public Response getError(){
        return Response.ok("Erro inDB").build();
    }
    public Response saveBrand(Brand brand){
        brandList.add(brand);
        return Response.accepted(brandList).build();
    }

    @PUT
    @Path("/{brand_name}")
    public Response updateBrand(@PathParam("brand_name") String brand_name, Brand brand) {
        brandList = brandList.stream().map(br -> {
            if (br.getBrand_name().equals(brand_name)) {
                return brand;
            } else {
                return br;
            }
        }).collect(Collectors.toList());
        return  Response.ok(brandList).build();
    }

@DELETE
@Path("/{brand_name}")
public Response deleteBrand(@PathParam("brand_name") String brand_name){
    brandList = brandList.stream()
            .filter(br -> !br.getBrand_name().equals(brand_name))
            .collect(Collectors.toList());

    return Response.ok().build();
}




}
