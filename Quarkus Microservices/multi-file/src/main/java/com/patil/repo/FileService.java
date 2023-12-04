package com.patil.repo;


import com.patil.entity.FileEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class FileService {

    @Inject
    FileRepository fileRepository;

    @Transactional
    public void saveFile(FileEntity fileEntity) {
        fileRepository.persist(fileEntity);
    }

    @Transactional
    public FileEntity getFileById(Long fileId) {
        return fileRepository.findById(fileId);
    }


    public List<FileEntity> getAllFiles() {
        return fileRepository.listAll();
    }

    // Other file-related operations
}