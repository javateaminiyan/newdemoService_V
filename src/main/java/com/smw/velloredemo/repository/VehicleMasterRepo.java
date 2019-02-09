package com.smw.velloredemo.repository;


import com.smw.velloredemo.dao.VehicleMasterDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleMasterRepo  extends JpaRepository<VehicleMasterDao,Long> {
}
