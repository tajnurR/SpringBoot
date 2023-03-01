package com.garmentsmanagement.GM.repository.clientRepository;

import com.garmentsmanagement.GM.entity.clientEntity.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICOrderRepository extends JpaRepository<ClientOrder, Long> {
    @Query("select c from ClientOrder c where  c.coCid.cid = ?1 ")
    public ClientOrder findClientOrderByCoCid(long cid);

    @Query("SELECT count(co.coid) FROM ClientOrder co where co.coCid.cid = ?1 ")
    public String findClientAllOrder(int cid);

    @Query("select co from ClientOrder co where co.coid = ?1")
    public ClientOrder findByOrderId(long coid);

}

