package com.patil.resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyReader;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Provider
@Consumes(MediaType.APPLICATION_OCTET_STREAM)
public class ListInputStreamMessageBodyReader implements MessageBodyReader<List<InputStream>> {

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return List.class.isAssignableFrom(type) && genericType instanceof ParameterizedType &&
                InputStream.class.isAssignableFrom((Class<?>) ((ParameterizedType) genericType).getActualTypeArguments()[0]);
    }

    @Override
    public List<InputStream> readFrom(Class<List<InputStream>> type, Type genericType, Annotation[] annotations,
                                      MediaType mediaType, MultivaluedMap<String, String> httpHeaders,
                                      InputStream entityStream) throws IOException, WebApplicationException {

        List<InputStream> inputStreams = new ArrayList<>();
        try {
            // Read the input stream and add it to the list
            inputStreams.add(entityStream);
            return inputStreams;
        } catch (Exception e) {
            throw new WebApplicationException("Error reading input stream", e);
        }
    }
}
