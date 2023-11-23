package com.patil.resource;

import com.patil.entity.Mobile;
import io.quarkus.runtime.annotations.ConfigDocDefault;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.*;
import java.util.stream.Collectors;

@Path("/mobile")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MobileResource {

    List<Mobile> mobileList = new ArrayList<>();

    @GET
    public Response getMobile(){
        return Response.ok(mobileList).build();
    }

    @POST
    public Response saveMobile(Mobile mob){
                mobileList.add(mob);
                return Response.accepted(mobileList).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateMob(@PathParam("id") int id,Mobile mobile){
        mobileList = mobileList.stream().map(mob -> {
            if(mob.getId()==id){
                return mobile;
            }else{
                return mob;
            }
        }).collect(Collectors.toList());
        return Response.ok(mobile).build();
    }
}
