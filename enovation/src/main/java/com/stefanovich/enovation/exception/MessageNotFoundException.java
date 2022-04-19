package com.stefanovich.enovation.exception;

import javax.persistence.EntityNotFoundException;

public class MessageNotFoundException extends EntityNotFoundException {
    public MessageNotFoundException(String message) {
        super(message);
    }
}
