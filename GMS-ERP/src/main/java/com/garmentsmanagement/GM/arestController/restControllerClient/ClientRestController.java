package com.garmentsmanagement.GM.arestController.restControllerClient;

import com.garmentsmanagement.GM.entity.clientEntity.ClientOrder;
import com.garmentsmanagement.GM.entity.clientEntity.ClientRegistration;
import com.garmentsmanagement.GM.entity.imageEntity.FileUploadDownload;
import com.garmentsmanagement.GM.service.FileUploadService;
import com.garmentsmanagement.GM.service.clientService.ClientRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "client/api")
@CrossOrigin("*")
public class ClientRestController {


    @Autowired
    ClientRegistrationService clientService;

    private String profileImg = "";

    @Autowired
    FileUploadService fileUploadService;


    @RequestMapping("/all_client")
    public List<ClientRegistration> allClient(){
        return clientService.getAllClientList();
        //country rest api all country
    }

    @PostMapping(value = "/save_client")
    public void addClient(@RequestBody ClientRegistration clientSave) throws IOException {
        clientSave.setClient_image(profileImg);
        clientService.saveClientInformation(clientSave);
    }

    @PostMapping(value = {"/uploadImg"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void uploadImg(@RequestPart("file") MultipartFile file) throws IOException {
        profileImg = fileUploadService.uploadImage(file);
    }

    @GetMapping("/get_img")
    public List<FileUploadDownload> getImagByte(){
        return fileUploadService.getImage();
    }

    @GetMapping("/get_img_by_name/{imgName}")
    public FileUploadDownload getImagname(@PathVariable("imgName")String imgName){
        return fileUploadService.downloadImage(imgName);
    }

}
