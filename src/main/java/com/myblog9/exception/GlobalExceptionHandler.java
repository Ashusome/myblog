package com.myblog9.exception;

import com.myblog9.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

public class GlobalExceptionHandler {


    public ResponseEntity<ErrorDetails> resourceNotFound(
            ResourceNotFound ex,
        WebRequest webRequest
        ){
            ErrorDetails err = new ErrorDetails(new Date(), ex.getMessage(), webRequest.getDescription(true));
            return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
        }
    }
