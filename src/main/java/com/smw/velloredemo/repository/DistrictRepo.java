package com.smw.velloredemo.repository;

import com.smw.velloredemo.dao.DistrictDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepo extends JpaRepository<DistrictDao,Long> {
}
