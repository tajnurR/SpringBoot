package com.garmentsmanagement.GM.service;

import com.garmentsmanagement.GM.entity.imageEntity.FileUploadDownload;
import com.garmentsmanagement.GM.repository.fileUploadRepo.FileUploadRepository;
import com.garmentsmanagement.GM.utility.ImgUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class FileUploadService {

    @Autowired
    private FileUploadRepository sRepo;

    public String uploadImage(MultipartFile file) throws IOException {
        String uniqFname = RandomStringUtils.randomAlphabetic(5)+file.getOriginalFilename();
        FileUploadDownload imageData = sRepo.save(FileUploadDownload.builder()
                .name(uniqFname)
                .type(file.getContentType())
                .imageData(ImgUtil.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return uniqFname;
        }
        return null;
    }

    public FileUploadDownload downloadImage(String fileName){
        FileUploadDownload dbImageData = sRepo.findByName(fileName);
        dbImageData.setImageData(ImgUtil.decompressImage(dbImageData.getImageData()));
        return dbImageData;
    }

    public List<FileUploadDownload> getImage(){
        List<FileUploadDownload> fd = sRepo.findAll();
        for (int i = 0; i < fd.size(); i++) {
            byte[] images=ImgUtil.decompressImage(fd.get(i).getImageData());
            fd.get(i).setImageData(images);
        }


        return fd;
    }

}
