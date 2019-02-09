package com.smw.velloredemo.repository;

import com.smw.velloredemo.dao.CompliantTypeDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Compliant_DropDownRepo  extends JpaRepository<CompliantTypeDao,Long> {
}
