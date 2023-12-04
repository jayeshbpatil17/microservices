package com.patil.entity;

import jakarta.ws.rs.FormParam;
import java.io.InputStream;
import java.util.List;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

import java.io.InputStream;
import java.util.List;

public class FileUploadForm {
    @FormParam("file")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    private byte[] fileContent;

    //

    @FormParam("fileContents")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    private List<InputStream> fileContents;

    public List<InputStream> getFileContents() {
        return fileContents;
    }

    public void setFileContents(List<InputStream> fileContents) {
        this.fileContents = fileContents;
    }


    @FormParam("fileName")
    @PartType(MediaType.TEXT_PLAIN)
    private String fileName;

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileUploadForm(byte[] fileContent, String fileName) {
        this.fileContent = fileContent;
        this.fileName = fileName;
    }

    public FileUploadForm() {
    }
}
