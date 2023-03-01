package com.garmentsmanagement.GM.repository.clientRepository;

import com.garmentsmanagement.GM.entity.clientEntity.ClientRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<ClientRegistration, Integer> {




}
