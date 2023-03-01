package com.garmentsmanagement.GM.controller.clientController;

import com.garmentsmanagement.GM.entity.clientEntity.ClientRegistration;
import com.garmentsmanagement.GM.repository.clientRepository.ICOrderRepository;
import com.garmentsmanagement.GM.service.clientService.ClientOrderService;
import com.garmentsmanagement.GM.service.clientService.ClientRegistrationService;
import com.garmentsmanagement.GM.service.clientService.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientRegistrationController {

    @Autowired
    ClientRegistrationService crService;

    @Autowired
    ICOrderRepository icOrderRepository;

    @Autowired
    CountryService cntService;
    @Autowired
    ClientOrderService coService;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    // Go to Client Registration form
    @RequestMapping("/client_reg_form")
    public String clientRegForm(Model m) {
        m.addAttribute("client_all_data", new ClientRegistration());
        m.addAttribute("viewCountry", cntService.getAllCountryList());
        m.addAttribute("title", "New Client Registration Form");


        return "client/client_reg_form";
    }


    //Client Registration From Action to save client data to dataBase
    @RequestMapping(value = "/save_client_submit", method = RequestMethod.POST)
    public String addNewClientForm(@ModelAttribute("client_all_data") ClientRegistration cr) {

        crService.saveClientInformation(cr);
        return "redirect:/client_list";
    }


    //This Page will Show All list of Client Data
    @RequestMapping("/client_list")
    public String allClientList(Model m) {
        m.addAttribute("allClient", crService.getAllClientList());
        return "client/client_list";
    }

    // Go to Client Profile Page
    @RequestMapping("/client_profile")
    public String clientProfilePage() {
        return "client/client_profile";
    }


    @RequestMapping("/client_profile/{cid}")
    public String clientProfile(@PathVariable("cid") Integer cid, Model m) {

        m.addAttribute("allOrderbyID", icOrderRepository.findClientOrderByCoCid(cid));
        m.addAttribute("allOrderbyClient", icOrderRepository.findClientAllOrder(cid));
    //    System.out.println(icOrderRepository.findClientAllOrder(1).toString());
        m.addAttribute("ClientProfile", crService.findClientById(cid));
        return "client/client_profile";
    }

    @RequestMapping("/update_client_profile/{cid}")
    public String clientUpdateForm(@PathVariable("cid") Integer cid, Model m) {
        m.addAttribute("title", "Update Client");
        ClientRegistration cr = crService.findClientById(cid);
        m.addAttribute("viewCountry", cntService.getAllCountryList());
        m.addAttribute("client_all_data", cr);

        return "client/client_reg_form";
    }


}
