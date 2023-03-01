package com.garmentsmanagement.GM.repository.clientRepository;

import com.garmentsmanagement.GM.entity.clientEntity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository extends JpaRepository<Country, Integer> {
}
