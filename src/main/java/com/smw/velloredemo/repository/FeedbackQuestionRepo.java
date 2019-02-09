package com.smw.velloredemo.repository;

import com.smw.velloredemo.dao.FeedbackQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackQuestionRepo extends JpaRepository<FeedbackQuestion, Long> {
}
