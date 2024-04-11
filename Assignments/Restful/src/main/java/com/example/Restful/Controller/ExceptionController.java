package com.example.Restful.Controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionController {
    private static final Logger logger = Logger.getLogger(ExceptionController.class);
    @ExceptionHandler(value = {IllegalArgumentException.class})
    public String handleException(IllegalArgumentException ex) {
        logger.error(ex);
        return "404";
    }

    @ExceptionHandler(value = {Exception.class})
    public String handleExceptionAll(Exception ex) {
        logger.error(ex);
        return "error";
    }
}
