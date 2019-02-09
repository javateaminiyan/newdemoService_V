package com.smw.velloredemo.repository;

import com.smw.velloredemo.dao.CompliantPriorityTypeDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Compliant_PriorityRepo  extends JpaRepository<CompliantPriorityTypeDao,Long> {
}
