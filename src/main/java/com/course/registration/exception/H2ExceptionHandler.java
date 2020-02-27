/*
 * Copyright (c) 2019. shangri-la.com. All Rights Reserved.
 */
package com.course.registration.exception;


import com.course.registration.controller.response.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;


@RestControllerAdvice
public class H2ExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(H2ExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = {Throwable.class})
    public APIResponse<String> handleSystemErrors(HttpServletRequest request, Throwable e) {
        LOGGER.error("err_exp,{}", request.getRequestURI(), e);
        return APIResponse.ofError("SERVICE_UNAVAILABLE");
    }

    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public APIResponse<String> handleSystemExceptions(HttpServletRequest request, Exception e) {
        LOGGER.error("sys_exp,{}", request.getRequestURI(), e);
        return APIResponse.ofError("INTERNAL_SERVER_ERROR");
    }

}
