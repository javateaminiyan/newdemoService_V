package com.smw.velloredemo.exception;

import org.hibernate.exception.ConstraintViolationException;

public class UserAlreadyExistsException extends RuntimeException {



    public UserAlreadyExistsException(String exception) {
        super(exception);
    }

    public UserAlreadyExistsException(ConstraintViolationException e) {
        super(e);
    }
}
