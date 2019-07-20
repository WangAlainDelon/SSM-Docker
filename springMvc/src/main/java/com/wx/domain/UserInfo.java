package com.wx.domain;

import com.wx.annotation.CannotHaveBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserInfo {
    /**
     * Min:设置最小值
     * Max:设置最大值
     * Message:打印信息
     */
    //指定年龄在18-120之间
    @Min(value = 18,message = "年龄不能小于18岁",groups = {Adult.class})
    @Max(value = 120,message = "年龄不能大于100岁")
    private Integer age;
    public interface Adult{}

    /**
     * 三种验证方式
     * @NotEmpty  用于集合
     * @NotNull   用于基本类型
     * @NotBlank  用于引用类型
     * @Size    设置大小
     */
    //非空验证
    @NotEmpty(message = "用户名不能为空")
    @Size(max = 20,min = 6,message = "用户名不能大于20个字符或小于6个字符")
    @CannotHaveBlank(message = "用户名字不能含空格",groups ={Bdult.class} )
    private String name;
    public interface Bdult{}

    /**
     * @Pattern  rehexp匹配正则
     */
    @NotEmpty(message = "邮箱不能为空")
    @Pattern(regexp = "^\\w+@\\w+/.\\w+$",message = "邮箱格式错误")
    private String email;

    @Pattern(regexp = "^1[35789]\\d{9}$",message = "手机号格式错误")
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
