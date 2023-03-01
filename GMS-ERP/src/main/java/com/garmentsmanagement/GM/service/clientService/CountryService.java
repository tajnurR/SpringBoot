package com.garmentsmanagement.GM.service.clientService;

import com.garmentsmanagement.GM.entity.clientEntity.Country;
import com.garmentsmanagement.GM.repository.clientRepository.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    ICountryRepository icntRepo;

    //this method for save student
    public void saveCountryName(Country cnt){
        icntRepo.save(cnt);
        //CRUD = C For Create;
    }

    public List<Country> getAllCountryList(){
        return icntRepo.findAll();
        //CRUD = R For Read or Get;
    }


    //this method for get icntRepo by id
    public Country findCountryById(int cntId){
        return icntRepo.findById(cntId).get();
        //CRUD = U For Update or Edit;
    }


    //this method for delete a icntRepo
    public void deleteCountry(int cntId){
        icntRepo.deleteById(cntId);
        //CRUD = D For Delete or Remove;
    }




}
