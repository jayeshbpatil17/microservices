package com.patil.entity;

import jakarta.ws.rs.FormParam;
import java.io.InputStream;
import java.util.List;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class FileUploadForm {

    @FormParam("fileContents")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    private List<InputStream> fileContents;


    public List<InputStream> getFileContents() {
        return fileContents;
    }

    public void setFileContents(List<InputStream> fileContents) {
        this.fileContents = fileContents;
    }



    public FileUploadForm() {
    }
}
