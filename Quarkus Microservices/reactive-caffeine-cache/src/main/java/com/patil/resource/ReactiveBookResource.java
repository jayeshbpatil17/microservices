package com.patil.resource;

import com.patil.entity.ReactiveBook;
import io.quarkus.cache.CacheResult;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.Vertx;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/reactive-books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReactiveBookResource {

    @GET
    @Path("/{id}")
    @CacheResult(cacheName = "reactiveBooksCache")
    public Uni<ReactiveBook> getBook(@PathParam("id") Long id){
        return ReactiveBook.findById(id);
    }

    @GET
    @CacheResult(cacheName = "reactiveBooksCache")
    public Uni<List<ReactiveBook>> getAllBook(){
        return  ReactiveBook.listAll();
    }

//    @POST
//    @Transactional
//    public Uni<Void> addBook(ReactiveBook book){
//        return  book.persist().map(unused->null);
//    }

    @POST
    @Transactional
    public Uni<Void> addBook(ReactiveBook book) {
        return book.persist().map(unused -> null);
    }
    
    @PUT
    @Path("/{id}")
    @Transactional
    public Uni<Void> update(@PathParam("id") int id, ReactiveBook book){
        return ReactiveBook.<ReactiveBook>findById(id)
                .onItem().ifNotNull().invoke(existingBook->{
                    existingBook.title=book.title;
                    existingBook.author=book.author;
                })
                .map(unused->null);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Uni<Void> deleteBook(@PathParam("id") Long id) {
        return ReactiveBook.deleteById(id).map(unused -> null);
    }

}
