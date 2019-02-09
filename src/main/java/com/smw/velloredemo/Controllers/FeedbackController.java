package com.smw.velloredemo.Controllers;


import com.smw.velloredemo.dao.Feedback;
import com.smw.velloredemo.response.Success;
import com.smw.velloredemo.service.IFeedback;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/feedback")
@RestController
public class FeedbackController {


    private final IFeedback feedbackService;

    @Autowired
    public FeedbackController(IFeedback feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/insertFeedback")
    public ResponseEntity<Object> insertCompliant(@Valid @RequestBody List<Feedback> feedback) {
        try {


            for(Feedback feedbackOne : feedback){
                if (feedbackOne.getQuestionname().matches("[0-9]+")) {
                    String questionname = feedbackService.getQuestions(Long.parseLong(feedbackOne.getQuestionname()));
                    feedbackOne.setQuestionname(questionname);
                    feedbackService.insertfeedback(feedbackOne);
                } else throw new NumberFormatException("Question id is invalid");

            }
        } catch (ConstraintViolationException e) { // detailed Exception is different by DBMS and JPA implemetation
            throw new IllegalArgumentException("Compliant not Inserted");
        }

        return new ResponseEntity<>(new Success(HttpStatus.CREATED, "New Compliant is created successfully"), HttpStatus.CREATED);
    }


    @GetMapping("/getAllQuestion")
    public ResponseEntity<Object> getAllQuestion() {

        if (feedbackService.getfeedbackquestions().size() > 0)
            return new ResponseEntity<>(new Success(HttpStatus.OK, feedbackService.getfeedbackquestions()), HttpStatus.OK);
        else
            return new ResponseEntity<>(new Success(HttpStatus.INTERNAL_SERVER_ERROR, "No Records Found"), HttpStatus.INTERNAL_SERVER_ERROR);

    }


    @GetMapping("/userFeedback/userid/{id}")
    public ResponseEntity<Object> getFeedbackCompliant(@PathVariable("id") Long id) {

        if (feedbackService.getfeedback("1004").isPresent())
            return new ResponseEntity<>(new Success(HttpStatus.OK, feedbackService.getfeedback("1004")), HttpStatus.OK);
        else
            return new ResponseEntity<>(new Success(HttpStatus.INTERNAL_SERVER_ERROR, "No Records Found"), HttpStatus.INTERNAL_SERVER_ERROR);

    }


}
