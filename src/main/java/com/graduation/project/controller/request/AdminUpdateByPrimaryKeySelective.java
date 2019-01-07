package com.graduation.project.controller.request;

import io.swagger.annotations.ApiModelProperty;

public class AdminUpdateByPrimaryKeySelective {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "手机号码，必填")
    private String phone;

    @ApiModelProperty(value = "密码，必填")
    private String password;

    @ApiModelProperty(value = "姓名，选填")
    private String trueName;

    @ApiModelProperty(value = "身份等级，必填")
    private String level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
