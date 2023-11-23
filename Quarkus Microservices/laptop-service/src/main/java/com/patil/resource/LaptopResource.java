package com.patil.resource;

import com.patil.entity.Laptop;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Path("/laptop")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LaptopResource {

    @GET
    public Response getAllLaptop() {
        List<Laptop> laptopList = Laptop.listAll();
        return Response.ok(laptopList).build();
    }

    @POST
    @Transactional
    public Response saveLaptop(Laptop laptop) {
        Laptop.persist(laptop);
        return Response.created(URI.create("/laptop/" + laptop.id)).build();
    }

    @GET
    @Path("/{id}")
    public Response getLaptopById(@PathParam("id") int id) {
        Laptop lap = Laptop.findById(id);
        return Response.ok(lap).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateLaptop(@PathParam("id") int id, Laptop laptop) {
        Optional<Laptop> optionalLaptop = Laptop.findByIdOptional(id);
        if (optionalLaptop.isPresent()) {

            Laptop dbLaptop = optionalLaptop.get();

            if (Objects.nonNull(laptop.getName())) {
                dbLaptop.setName(laptop.getName());
            }
            if (Objects.nonNull(laptop.getBrand())) {
                dbLaptop.setBrand(laptop.getBrand());
            }
            if (Objects.nonNull(laptop.getRam())) {
                dbLaptop.setRam(laptop.getRam());
            }
            if (Objects.nonNull(laptop.getExternalStorage())) {
                dbLaptop.setExternalStorage(laptop.getExternalStorage());
            }
            dbLaptop.persist();
        }
        if (laptop.isPersistent()) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteLaptopById(@PathParam("id") int id){
        boolean isDeleted = Laptop.deleteById(id);
        if(isDeleted){
            return Response.ok().build();
        }else{
            return  Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}




