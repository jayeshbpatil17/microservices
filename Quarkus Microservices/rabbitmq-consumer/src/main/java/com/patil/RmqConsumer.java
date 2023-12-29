package com.patil;

import io.quarkus.logging.Log;
import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class RmqConsumer {

    @Incoming("test-queue")
    public void process(JsonObject msg){
        Log.info(msg);
    }
}
