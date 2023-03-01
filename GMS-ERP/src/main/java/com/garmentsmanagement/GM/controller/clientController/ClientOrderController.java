package com.garmentsmanagement.GM.controller.clientController;

import com.garmentsmanagement.GM.entity.clientEntity.ClientOrder;
import com.garmentsmanagement.GM.service.clientService.ClientOrderService;
import com.garmentsmanagement.GM.service.clientService.ClientRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientOrderController {

    @Autowired
    ClientOrderService coService;
    @Autowired
    ClientRegistrationService crService;

    // Go to Client Order form
    @RequestMapping("/client_order_form/{cid}")
    public String clientOrderPage(@PathVariable("cid") Integer cid, Model m){
        m.addAttribute("clientOrderform", new ClientOrder());
        m.addAttribute("title", "Client Order form");
        m.addAttribute("ClientProfile",  crService.findClientById(cid));
        return "client/client_order_form";
    }

    // Order Form Via Client Profile
//    @RequestMapping("/client_order_form/{cid}")
//    public String clientOrderPage(Model m){
//        m.addAttribute("clientOrderform", new ClientOrder());
//        m.addAttribute("title", "Client Order form");
//        return "client_order_form";
//    }


    //Client Order Form Action to save client Order Details to dataBase
    @RequestMapping(value = "/new_order_reg", method = RequestMethod.POST)
    public String addNewOrder(@ModelAttribute("clientOrderform") ClientOrder co, Model m ){

        coService.saveOrderInformation(co);
        return "redirect:/client_order_list";
    }




    //This Page will Show All list of Client Data
    @RequestMapping("/client_order_list")
    public String allOrderList(Model m){
        m.addAttribute("allOrder", coService.getAllOrderList());
        m.addAttribute("allClient", crService.getAllClientList());
        return "client/client_order_list";
    }






// This will Swich To Production Controller
    @RequestMapping("/production_requisition")
    public String productionLinePage() {
        return "production_line/production_requisition";
    }

// This will Swich To Production Controller
    @RequestMapping("/client_order_details")
    public String clientOrderDetails() {
        return "production_line/client_order_details";
    }






}
