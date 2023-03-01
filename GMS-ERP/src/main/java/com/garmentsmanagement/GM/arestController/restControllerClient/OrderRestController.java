package com.garmentsmanagement.GM.arestController.restControllerClient;

import com.garmentsmanagement.GM.entity.clientEntity.ClientOrder;
import com.garmentsmanagement.GM.entity.clientEntity.ClientRegistration;
import com.garmentsmanagement.GM.entity.clientEntity.Country;
import com.garmentsmanagement.GM.entity.productionLine.InventoryPL;
import com.garmentsmanagement.GM.repository.clientRepository.ICOrderRepository;
import com.garmentsmanagement.GM.repository.productionLine.InventoryPlRepo;
import com.garmentsmanagement.GM.service.FileUploadService;
import com.garmentsmanagement.GM.service.clientService.ClientOrderService;
import com.garmentsmanagement.GM.service.clientService.ClientRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "client/order/api")
@CrossOrigin("*")
public class OrderRestController {
    @Autowired
    ClientOrderService coService;

    @Autowired
    ClientRegistrationService clientService;

    private String profileImg = "";

    @Autowired
    FileUploadService fileUploadService;

    @Autowired
    ICOrderRepository icOrderRepository;

    @Autowired
    InventoryPlRepo inventoryPlRepo;

    @RequestMapping("/all_order")
    public List<ClientOrder> allOrder(){
        return coService.getAllOrderList();
        //country rest api all country
    }

    @PostMapping(value = "/save_order")
    public void addClient(@RequestBody ClientOrder clientOrder) throws IOException {
        clientOrder.setOder_s_img(profileImg);
        clientOrder.setOrderStatus(1);
//        coService.saveOrderInformation(clientOrder);
       ClientOrder c = icOrderRepository.saveAndFlush(clientOrder);
        System.out.println(c.getCoid());
        InventoryPL invp = new InventoryPL();
        invp.setClientOrder(new ClientOrder(c.getCoid()));
        invp.setInv_Delivary_status(1);
        invp.setInv_status(1);
        inventoryPlRepo.save(invp);
    }

    @PostMapping(value = {"/uploadOrderImg"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void uploadOrderImg(@RequestPart("file") MultipartFile file) throws IOException {
        profileImg = fileUploadService.uploadImage(file);
    }


}
