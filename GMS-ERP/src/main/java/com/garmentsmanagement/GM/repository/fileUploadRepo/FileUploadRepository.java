package com.garmentsmanagement.GM.repository.fileUploadRepo;

import com.garmentsmanagement.GM.entity.imageEntity.FileUploadDownload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileUploadRepository extends JpaRepository<FileUploadDownload, Long> {
    FileUploadDownload findByName(String fileName);

    @Query("select img from FileUploadDownload img where img.name = ?1")
    FileUploadDownload findImgByName(String fileName);

}
