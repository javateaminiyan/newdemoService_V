package com.smw.velloredemo.repository;

import com.smw.velloredemo.dao.CategoryVehicleDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryVehicleRepo  extends JpaRepository<CategoryVehicleDao,Long> {
}
