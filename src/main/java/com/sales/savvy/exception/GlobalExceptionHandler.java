package com.sales.savvy.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex) {
        logger.error("CRITICAL EXCEPTION CAPTURED BY GLOBAL HANDLER", ex);

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String stackTrace = sw.toString();

        Map<String, Object> body = new HashMap<>();
        body.put("message", "Internal Server Error (Captured by Global Handler)");
        body.put("error", ex.getClass().getName());
        body.put("details", ex.getMessage());
        // Truncate stack trace to avoid massive JSON
        body.put("stackTrace", stackTrace.substring(0, Math.min(stackTrace.length(), 2000)));

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
