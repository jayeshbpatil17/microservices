package com.patil.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;

@jakarta.ws.rs.Path("/files")
public class GreetingResource {

    @Inject
    FileService fileService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String uploadFiles(List<String> filePaths) {
        try {
            fileService.saveFilesToDatabase(filePaths.stream().map(Path::of).toList());
            return "Files uploaded successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error uploading files: " + e.getMessage();
        }
    }

//    Create a POST Request in Postman:
//    Open Postman and create a new request:
//
//    Set the request type to POST.
//    Set the request URL to http://localhost:8080/files.
//    Set the request body to raw and select JSON (application/json).
//    Provide File Paths in the Request Body:
//    In the request body, provide an array of file paths. For example:
//
//    json
//    Copy code
//["/path/to/file1.txt", "/path/to/file2.txt", "/path/to/file3.txt"]


}
