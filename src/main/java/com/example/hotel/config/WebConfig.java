package com.example.hotel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@Configuration
@ControllerAdvice //any where error that handle
public class WebConfig implements WebMvcConfigurer {


    @ExceptionHandler({IllegalArgumentException.class, EntityNotFoundException.class})
    public ModelAndView handleException(HttpServletRequest request,Exception ex){
        ModelAndView model = new ModelAndView();
        model.addObject("exception",ex);
        model.addObject("message",ex.getMessage());
        model.addObject("url",request.getRequestURI());
        model.setViewName("admin/roomexistederror");

        return model;
    }
}
