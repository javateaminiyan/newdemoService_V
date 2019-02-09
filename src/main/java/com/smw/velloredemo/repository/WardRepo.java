package com.smw.velloredemo.repository;

import com.smw.velloredemo.dao.WardDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public interface WardRepo extends JpaRepository<WardDao,Long> {



    @Query("select  j from WardDao  j  where districtid=:districtid")
    List<WardDao> findDistrictId(long districtid);



    @Query("select  j from WardDao  j  where zoneid in (:zone) and mccid in (:mcc)")
    List<WardDao> findbyzoneandward(int[] zone,int[] mcc);

}
