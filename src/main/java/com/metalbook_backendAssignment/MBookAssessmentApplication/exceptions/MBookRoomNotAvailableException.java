package com.metalbook_backendAssignment.MBookAssessmentApplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

public class MBookRoomNotAvailableException extends RuntimeException {
    public MBookRoomNotAvailableException(String msg) {
        super(msg);
    }
}
