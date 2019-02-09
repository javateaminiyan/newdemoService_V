package com.smw.velloredemo.service;

import com.smw.velloredemo.dao.Feedback;
import com.smw.velloredemo.dao.FeedbackQuestion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IFeedback {



    Optional<Feedback> getfeedback(String id);


    List<FeedbackQuestion> getfeedbackquestions();


    Feedback insertfeedback(Feedback feedback);


    String getQuestions(Long id);
}
