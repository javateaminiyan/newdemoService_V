package com.smw.velloredemo.repository;

import com.smw.velloredemo.dao.ZoneDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ZoneRepo extends JpaRepository<ZoneDao,Long> {


    @Query("select j from ZoneDao  j where ZoneId in (:zoneid)")
    List<ZoneDao> findByZoneId(long[] zoneid);
}
