//package com.patil.resource;
//
//
//import jakarta.ws.rs.FormParam;
//import jakarta.ws.rs.core.MediaType;
//import org.jboss.resteasy.annotations.providers.multipart.PartType;
//
//
//
//public class FileUploadForm {
//
//    @FormParam("file")
//    @PartType(MediaType.APPLICATION_OCTET_STREAM)
//    private byte[] fileContent;
//
//    @FormParam("fileName")
//    @PartType(MediaType.TEXT_PLAIN)
//    private String fileName;
//
//    public FileUploadForm() {
//    }
//
//    public FileUploadForm(byte[] fileContent, String fileName) {
//        this.fileContent = fileContent;
//        this.fileName = fileName;
//    }
//
//    public byte[] getFileContent() {
//        return fileContent;
//    }
//
//    public void setFileContent(byte[] fileContent) {
//        this.fileContent = fileContent;
//    }
//
//    public String getFileName() {
//        return fileName;
//    }
//
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
//
//    // Constructors, getters, setters
//}
