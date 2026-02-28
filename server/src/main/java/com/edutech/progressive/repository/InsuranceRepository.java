package com.edutech.progressive.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edutech.progressive.entity.Insurance;
@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Integer>{
     Insurance findByInsuranceId(int insuranceId);
 
    @Modifying
    @Transactional
    @Query("DELETE FROM Insurance ins WHERE ins.shipment.shipmentId = :shipmentId")
    void deleteByShipmentId(@Param("shipmentId") int shipmentId);
}
