package com.wx.error;

import com.sun.glass.ui.View;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CustomExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof IOException) {
            return new ModelAndView("error");
        } else if (e instanceof SQLException) {
            return new ModelAndView("error");
        } else if (e instanceof MyException) {
            modelAndView.addObject("msg", e.getMessage());
            modelAndView.setViewName("error");
            return modelAndView;
        }
        return null;
    }
}
