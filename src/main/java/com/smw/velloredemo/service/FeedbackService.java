package com.smw.velloredemo.service;

import com.smw.velloredemo.dao.Feedback;
import com.smw.velloredemo.dao.FeedbackQuestion;
import com.smw.velloredemo.repository.FeedbackQuestionRepo;
import com.smw.velloredemo.repository.FeedbackUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService implements IFeedback {
    private final FeedbackQuestionRepo feedbackQuestionRepo;

    private final FeedbackUserRepo feedbackUserRepo;

    @Autowired
    public FeedbackService(FeedbackQuestionRepo feedbackQuestionRepo, FeedbackUserRepo feedbackUserRepo) {
        this.feedbackQuestionRepo = feedbackQuestionRepo;
        this.feedbackUserRepo = feedbackUserRepo;
    }


    @Override
    public Optional<Feedback> getfeedback(String id) {
        return feedbackUserRepo.findbyuserid(id);


    }

    @Override
    public List<FeedbackQuestion> getfeedbackquestions() {
        return feedbackQuestionRepo.findAll();
    }

    @Override
    public Feedback insertfeedback(Feedback feedback) {
        return feedbackUserRepo.save(feedback);
    }

    @Override
    public String getQuestions(Long id) {
        return feedbackQuestionRepo.findById(id).get().getQuestions();
    }
}
