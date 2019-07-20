package com.wx.controller;

import com.wx.domain.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.validation.Valid;

/**
 * 完成SpringMVC的数据校验
 * 1.导包
 * 2.配置包扫描
 * 3.xml配置
 * 4.添加实体类
 * 5.测试
 */
@Controller
public class ValidDataController {

    @RequestMapping("/validdata")
    public String validdata(@Valid UserInfo userInfo, BindingResult br, Model mv) {
        int errorCount = br.getErrorCount();
        if (errorCount > 0) {
            //证明至少有一个参数错误
            //获取信息
            FieldError name = br.getFieldError("name");
            FieldError age = br.getFieldError("age");
            FieldError phone = br.getFieldError("phone");
            FieldError email = br.getFieldError("email");

            //获取错误信息
            if (name != null) {
                String namemsg = name.getDefaultMessage();
                //把错误信息返回到页面
                mv.addAttribute("namemsg", namemsg);
            }
            if (age != null) {
                String agemsg = age.getDefaultMessage();
                mv.addAttribute("agemsg", agemsg);
            }
            if (phone != null) {
                String phonemsg = phone.getDefaultMessage();
                mv.addAttribute("phonemsg", phonemsg);
            }
            if (email != null) {
                String emailmsg = email.getDefaultMessage();
                mv.addAttribute("emailmsg", emailmsg);
            }
        }
        return "validdata";
    }
    @RequestMapping("/validdatagroup")
    public String validdatagroup(@Validated({UserInfo.Adult.class,UserInfo.Bdult.class}) UserInfo userInfo, BindingResult br, Model mv) {
        int errorCount = br.getErrorCount();
        if (errorCount > 0) {
            //证明至少有一个参数错误
            //获取信息
            FieldError name = br.getFieldError("name");
            FieldError age = br.getFieldError("age");
            FieldError phone = br.getFieldError("phone");
            FieldError email = br.getFieldError("email");

            //获取错误信息
            if (name != null) {
                String namemsg = name.getDefaultMessage();
                //把错误信息返回到页面
                mv.addAttribute("namemsg", namemsg);
            }
            if (age != null) {
                String agemsg = age.getDefaultMessage();
                mv.addAttribute("agemsg", agemsg);
            }
            if (phone != null) {
                String phonemsg = phone.getDefaultMessage();
                mv.addAttribute("phonemsg", phonemsg);
            }
            if (email != null) {
                String emailmsg = email.getDefaultMessage();
                mv.addAttribute("emailmsg", emailmsg);
            }
        }
        return "validdata";
    }
}
