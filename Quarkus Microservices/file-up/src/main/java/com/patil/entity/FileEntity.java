package com.patil.entity;




import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FileEntity extends PanacheEntityBase {

    @Id
    public int id;

    public String fileName;
    public byte[] fileContent;
}

