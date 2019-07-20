package com.wx.controller;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SeniorQueryController {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/")
    public void query() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

    }
}
