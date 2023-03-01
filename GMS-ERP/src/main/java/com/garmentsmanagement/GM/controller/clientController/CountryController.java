package com.garmentsmanagement.GM.controller.clientController;

import com.garmentsmanagement.GM.entity.clientEntity.Country;
import com.garmentsmanagement.GM.service.clientService.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CountryController {

    @Autowired
    CountryService cntService;

    // Go to  Country form
    @RequestMapping("/add_country")
    public String allConutry(Model m){
        m.addAttribute("viewCountry", cntService.getAllCountryList());
        m.addAttribute("cnt", new Country());
        m.addAttribute("title", "Add New Country");

        return "country_list";
    }

    @RequestMapping(value = "/country_save", method = RequestMethod.POST)
    public  String addCountry(@ModelAttribute("cnt") Country cnt){
        cntService.saveCountryName(cnt);

        return  "redirect:/add_country";
    }


    @RequestMapping("/country_update/{cntId}")
    public String updateCountryList(@PathVariable("cntId") Integer cntId, Model m){
        m.addAttribute("cnt",  cntService.findCountryById(cntId));

        return "country_list";
    }

    @RequestMapping("/country_delete/{cntId}")
    public String countryDelete(@PathVariable("cntId") Integer cntId) {
        cntService.deleteCountry(cntId);

        return "redirect:/add_country";
    }



}
