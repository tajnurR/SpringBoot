package com.garmentsmanagement.GM.arestController.restControllerClient;


import com.garmentsmanagement.GM.entity.clientEntity.Country;
import com.garmentsmanagement.GM.repository.clientRepository.ICountryRepository;
import com.garmentsmanagement.GM.service.clientService.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "client/api")
@CrossOrigin("*")
public class CountryRestController {

    @Autowired
    CountryService countryService;
    @Autowired
    private ICountryRepository countryRepository;


    @RequestMapping("/all_country")
    public List<Country> allCountry(){
        return countryService.getAllCountryList();
        //country rest api all country
    }
    @PostMapping(value = "/save_country")
    public void addCountry(@RequestBody Country cnt){
        countryService.saveCountryName(cnt);
    }


    @GetMapping(value = "/country_find_by_id/{cntId}")
    public Optional<Country> updateCountry(@PathVariable("cntId") int cntId){
        return countryRepository.findById(cntId);
        //Why Optional use here...
    }



    @PutMapping(value = "/update_country")
    public void updateCountry(@RequestBody Country cnt){
        countryService.saveCountryName(cnt);
        // have a confution to ask = Why not using /{cntId} for update;
    }

    @DeleteMapping(value = "/country_delete/{cntId}")
    public void countryDelete(@PathVariable("cntId") int cntId){
        countryRepository.deleteById(cntId);
    }

}
