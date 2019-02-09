package com.smw.velloredemo.repository;

import com.smw.velloredemo.dao.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Transactional
@Repository
public interface FeedbackUserRepo extends JpaRepository<Feedback, Long> {


    @Query("select  j  from Feedback  j where userid=:id")
    Optional<Feedback> findbyuserid(String id);

}
