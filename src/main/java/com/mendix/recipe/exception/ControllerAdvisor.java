package com.mendix.recipe.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.persistence.EntityExistsException;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

        private final Logger logger = LoggerFactory.getLogger(this.getClass());

        @ExceptionHandler(NoDataFoundException.class)
        public ResponseEntity<Object> handleNoDataFoundException(
                        NoDataFoundException ex) {

                ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                                ex.getMessage(),
                                LocalDateTime.now());

                logger.info("Not Data Found Exception: {}", ex.getMessage());
                return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(EntityExistsException.class)
        public ResponseEntity<Object> handleEntityExistsException(
                        EntityExistsException ex) {

                ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                                "Object Already Exists and Cannot be Duplicated",
                                LocalDateTime.now());

                logger.info("Already Exists Exception: {}", ex.getMessage());
                return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        @Override
        protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                        HttpHeaders headers, HttpStatusCode status, WebRequest request) {
                ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                                "Request Format is not Valid",
                                LocalDateTime.now());

                logger.info("Invalid Request Format Exception: {}", ex.getMessage());
                return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                        HttpHeaders headers, HttpStatusCode status, WebRequest request) {
                ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                                ex.getBindingResult()
                                                .getFieldErrors()
                                                .stream()
                                                .map(fieldError -> fieldError.getDefaultMessage())
                                                .collect(Collectors.toList()).toString(),
                                LocalDateTime.now());

                logger.info("Invalid Request Exception: {}", ex.getMessage());
                return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<Object> handleGlobalException(
                        Exception ex) {

                ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                "Internal Server Error, Please Contact Developer",
                                LocalDateTime.now());

                logger.info("Exception: {}", ex.getMessage());
                return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

}
