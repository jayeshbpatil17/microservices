package com.patil.repo;

import com.patil.entity.FileEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.sql.Blob;

@ApplicationScoped
public class FileRepo implements PanacheRepository<FileEntity> {
    @Transactional
    public void saveFile(String fileName, Blob fileContent) {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(fileName);
        fileEntity.setFileContent(fileContent);
        persist(fileEntity);
    }
}
