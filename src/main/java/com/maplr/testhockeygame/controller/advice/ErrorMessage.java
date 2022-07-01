package com.maplr.testhockeygame.controller.advice;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {

    private final int statusCode;
    private final ZonedDateTime timestamp;
    private final String message;
    private final String description;
    private final List<FieldError> fieldErrors;


    public ErrorMessage(int statusCode, ZonedDateTime timestamp, String message, String description) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
        this.fieldErrors = new ArrayList<>();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public void addFieldError(String field, String message) {
        FieldError error = new FieldError(field, message);
        fieldErrors.add(error);
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }

    private static class FieldError {
        private final String field;
        private final String message;

        public FieldError(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public String getMessage() {
            return message;
        }
    }

}
