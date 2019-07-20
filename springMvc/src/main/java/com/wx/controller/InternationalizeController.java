package com.wx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;
import java.util.Map;

@Controller
public class InternationalizeController {
    @Autowired
    private MessageSource messageSource;

    /**
     * 在跳转页面的时候需要加载国际化资源
     * @param locale
     * @param map
     * @return
     */
    @RequestMapping("/hello")
    public String index(Locale locale, Map<String ,Object> map) {
        String name = messageSource.getMessage("loginname", null, locale);
        String pass = messageSource.getMessage("password", null, locale);
        String submit = messageSource.getMessage("submit", null, locale);
        String welcome = messageSource.getMessage("welcome", null, locale);
        String title = messageSource.getMessage("title", null, locale);

        map.put("loginname", title);
        map.put("password", pass);
        map.put("submit", name);
        map.put("welcome", submit);
        map.put("title", submit);
        /*map.put("user", new User());*/

        return "hello";
    }

}
