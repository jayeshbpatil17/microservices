package com.patil.resource;





import com.patil.repo.FileRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class FileService {

    @Inject
    FileRepo fileEntityRepository;


    public void saveFilesToDatabase(List<Path> filePaths) {
        for (Path filePath : filePaths) {
            try {
                saveFileToDatabase(filePath);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
                // Log or handle the exception as needed
            }
        }
    }

    private void saveFileToDatabase(Path filePath) throws IOException, SQLException {
        String fileName = filePath.getFileName().toString();
        byte[] fileBytes = Files.readAllBytes(filePath);

        // Convert byte array to Blob using Jakarta EE's SerialBlob
        Blob fileContent = new javax.sql.rowset.serial.SerialBlob(fileBytes);

        // Save file information to the database
        fileEntityRepository.saveFile(fileName, fileContent);
    }
}
