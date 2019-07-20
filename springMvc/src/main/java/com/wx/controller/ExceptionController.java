package com.wx.controller;

import com.wx.error.MyException;
import com.wx.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {
    @Autowired
    private FilmService filmService;
    @RequestMapping("/exception1")
    @ResponseBody
    public String exception1() throws Exception {
        System.out.println("alalaal");
        //当某种业务条件不满足的时候抛出异常
        boolean condition = true;
        if (condition) {
            MyException myException = new MyException("Controller层异常");
            throw myException;
        }
        return "string";
    }
    @RequestMapping("/exception2")
    @ResponseBody
    public String exception2() throws Exception {
        System.out.println("alalaal");
        //当某种业务条件不满足的时候抛出异常
        filmService.exception();
        return "string";
    }
}
