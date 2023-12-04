package com.patil.resource;

import com.patil.entity.FileEntity;
import com.patil.entity.FileUploadForm;
import com.patil.repo.FileService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Path("/files")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FileController {

    @Inject
    FileService fileService;
//
//    @POST
//    @Path("/upload")
//    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
//    @Transactional
//    public void uploadFile(byte[] fileContent) {
//        FileEntity fileEntity = new FileEntity();
//        fileEntity.setFileContent(fileContent);
//        fileService.saveFile(fileEntity);
//    }
//
//
//    @GET
//    @Path("/{fileId}")
//    public FileEntity getFileById(@PathParam("fileId") Long fileId) {
//        return fileService.getFileById(fileId);
//    }
//

//ver last changed
    @POST
    @Path("/uploadMultiple")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Transactional
    public Response uploadMultipleFiles(@MultipartForm FileUploadForm form) {
        List<InputStream> fileContents = form.getFileContents();
        for (InputStream inputStream : fileContents) {
            try {
                byte[] content = inputStream.readAllBytes();
                FileEntity fileEntity = new FileEntity();
                fileEntity.setFileContent(content);
                fileService.saveFile(fileEntity);
            } catch (Exception e) {
                e.printStackTrace();
                // Handle exceptions
            }
        }
        return Response.status(Response.Status.CREATED).build();
    }

/*
If you expect to receive large files, consider utilizing libraries like Apache Commons
 FileUpload or MultipartStream to handle them efficiently. These libraries offer features
 like streaming uploads and temporary storage to avoid memory limitations.


 */


//    @GET
//    @Path("/download/{fileId}")
//    @Produces(MediaType.APPLICATION_OCTET_STREAM)
//    public Response downloadFile(@PathParam("fileId") Long fileId) {
//        FileEntity fileEntity = fileService.getFileById(fileId);
//
//        if (fileEntity == null) {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//
//        try {
//            String fileName = "downloaded_file"; // You may get the original file name from the entity
//            String encodedFileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
//
//            return Response
//                    .ok(fileEntity.getFileContent())
//                    .header("Content-Disposition", "attachment; filename=\"" + encodedFileName + "\"")
//                    .build();
//        } catch (UnsupportedEncodingException e) {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
//        }
//    }

//    @GET
//    @Path("/download/{fileId}")
//    @Produces(MediaType.APPLICATION_OCTET_STREAM)
//    public Response downloadFile(@PathParam("fileId") Long fileId) {
//        FileEntity fileEntity = fileService.getFileById(fileId);
//
//        if (fileEntity == null) {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//
//        try {
//            String fileName = "downloaded_file"; // You may get the original file name from the entity
//            String encodedFileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
//
//            return Response
//                    .ok(fileEntity.getFileContent())
//                    .header("Content-Disposition", "attachment; filename=\"" + encodedFileName + "\"")
//                    .build();
//        } catch (UnsupportedEncodingException e) {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
//        }
//    }



//    @POST
//    @Path("/upload")
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    public Response uploadFile(@MultipartForm FileUploadForm form) {
//        byte[] fileContent = form.getFileContent();
//        String fileName = form.getFileName();
//
//        FileEntity fileEntity = new FileEntity();
//        fileEntity.setFileContent(fileContent) ;
//        fileEntity.setFileName(fileName);
//
//        fileService.saveFile(fileEntity);
//
//        return Response.status(Response.Status.CREATED).build();
//    }

//    @GET
//    @Path("/download/{fileId}")
//    @Produces(MediaType.APPLICATION_OCTET_STREAM)
//    public Response downloadFile(@PathParam("fileId") Long fileId) {
//        FileEntity fileEntity = fileService.getFileById(fileId);
//
//        if (fileEntity == null) {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//
//        try {
//            String encodedFileName = URLEncoder.encode(fileEntity.fileName, "UTF-8").replaceAll("\\+", "%20");
//
//            return Response
//                    .ok(fileEntity.getFileContent())
//                    .header("Content-Disposition", "attachment; filename=\"" + encodedFileName + "\"")
//                    .build();
//        } catch (UnsupportedEncodingException e) {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
//        }
//    }

//    @GET
//    @Path("/list")
//    public List<FileEntity> listFiles() {
//        return fileService.getAllFiles();
//    }

}

