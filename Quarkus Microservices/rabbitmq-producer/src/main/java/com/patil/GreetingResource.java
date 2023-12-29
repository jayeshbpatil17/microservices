package com.patil;

import io.vertx.core.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@Path("/hello")
public class GreetingResource {

    @Channel("test-queue")
    Emitter<JsonObject> emitter;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        JsonObject obj = new JsonObject();
        obj.put("Hello","World");
        emitter.send(obj);
        return "Hello from RESTEasy Reactive";
    }
}
