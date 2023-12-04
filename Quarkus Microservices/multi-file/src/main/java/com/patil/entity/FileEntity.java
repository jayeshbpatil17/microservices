package com.patil.entity;


import jakarta.persistence.*;

@Entity
@Table(name="multi_file")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] fileContent;





    public FileEntity(Long id, byte[] fileContent) {
        this.id = id;
        this.fileContent = fileContent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    public FileEntity() {
    }

    // getters and setters
}
