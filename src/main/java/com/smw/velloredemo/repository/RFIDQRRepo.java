package com.smw.velloredemo.repository;


import org.springframework.data.repository.query.Param;
import com.smw.velloredemo.dao.RFIDDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface RFIDQRRepo extends JpaRepository<RFIDDao, Long> {


    @Query("select  j From RFIDDao j where rfidno=:input or userid=:input")
    Optional<RFIDDao> checkRfidorQR(String input);



//    @Query("select  j From RFIDDao j where rfidno=:input or userid=:input")
//    Optional<RFIDDao> checkUserDetails(String input);



//
//    @Query(value = "SELECT * FROM swm.login JOIN rfid_log ON swm.login.userid=rfid_log.userid where rfid_log.rfidno='9894591650' or rfid_log.userid='9894591650'",nativeQuery = true)   // call store procedure with arguments
//    Optional<Object> findUserDetailsFromRfid(String role);




}
