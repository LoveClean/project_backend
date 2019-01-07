package com.graduation.project.controller.request;

import io.swagger.annotations.ApiModelProperty;

public class MapsUpdateByPrimaryKeySelective {
    @ApiModelProperty(value = "必填")
    private Integer id;

    @ApiModelProperty(value = "必填")
    private String name;

    @ApiModelProperty(value = "联系人号码，必填")
    private String phone;

    @ApiModelProperty(value = "地区代码，必填")
    private String areaId;

    @ApiModelProperty(value = "网点详细地址")
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
