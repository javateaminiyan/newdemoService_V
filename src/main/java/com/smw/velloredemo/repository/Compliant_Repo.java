package com.smw.velloredemo.repository;

import com.smw.velloredemo.dao.CompliantDao;
import com.smw.velloredemo.dao.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
@Repository
public interface Compliant_Repo extends JpaRepository<CompliantDao,Long> {


    @Query("select  j  from CompliantDao  j where userid=:id  order by id desc")
    List<CompliantDao> findbyUserId(String id);

    @Modifying
    @Query("update  CompliantDao m set  statusissues= ?2 where id in ?1")
    void updatestatusissues(long compliantid, String statusissuess);




}
