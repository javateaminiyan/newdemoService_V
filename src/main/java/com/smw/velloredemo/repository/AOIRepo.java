package com.smw.velloredemo.repository;

import com.smw.velloredemo.dao.AreaofInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AOIRepo extends JpaRepository<AreaofInterest, Long> {
}
