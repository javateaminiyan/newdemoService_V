package com.smw.velloredemo.repository;

import com.smw.velloredemo.dao.AlertSubscriptionUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface AlertSubscriptionUserRepo extends JpaRepository<AlertSubscriptionUser,Long> {


  @Query("select distinct userid  from AlertSubscriptionUser j where userid=:userid")
  List<Object> findbyUserid(String userid);


  @Modifying
  @Query("Update   AlertSubscriptionUser j set status=:status where  id=:id")
    void updateById(String status,long id );
}
