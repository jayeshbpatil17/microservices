package com.patil.resource;

import com.patil.entity.FileEntity;
import io.quarkus.panache.common.Sort;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.util.List;


@Path("/files")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.MULTIPART_FORM_DATA)
public class FileResource {

    @POST
    @Transactional
    public Response uploadFile(@MultipartForm FormData formData) throws IOException {
        try {
            FileEntity fileEntity = new FileEntity();
            fileEntity.fileName = formData.fileName;
            fileEntity.fileContent = formData.file.readAllBytes();
            fileEntity.persist();
            return Response.ok().build();
        }catch(Exception e){
            e.printStackTrace(); // Log the exception
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @GET
    public List<FileEntity> listFiles() {
        return FileEntity.listAll(Sort.by("id"));
    }
}
