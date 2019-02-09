package com.smw.velloredemo.repository;


import com.smw.velloredemo.Pojo.MccDao;
import com.smw.velloredemo.dao.WardDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface MccRepo extends JpaRepository<MccDao, Long> {



    @Query("select j from MccDao  j where zoneid in (:zone)")
    List<MccDao> findbyzone(String[] zone);
}
