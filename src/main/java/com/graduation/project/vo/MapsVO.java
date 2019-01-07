package com.graduation.project.vo;

import com.graduation.project.dao.entity.Maps;
import com.graduation.project.util.ResponseEntity;

import java.util.Date;

public class MapsVO {
    private Integer id;
    private String name;
    private String phone;
    private String areaId;
    private Object areaAddress;
    private String address;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private String remarks;
    private String delFlag;

    public MapsVO() {
    }

    public MapsVO(Maps maps, ResponseEntity areaAddress) {
        this.id = maps.getId();
        this.name = maps.getName();
        this.phone = maps.getPhone();
        this.areaId = maps.getAreaId();
        this.areaAddress = areaAddress.getData();
        this.address = maps.getAddress();
        this.createBy = maps.getCreateBy();
        this.createDate = maps.getCreateDate();
        this.updateBy = maps.getUpdateBy();
        this.updateDate = maps.getUpdateDate();
        this.remarks = maps.getRemarks();
        this.delFlag = maps.getDelFlag();
    }

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

    public Object getAreaAddress() {
        return areaAddress;
    }

    public void setAreaAddress(Object areaAddress) {
        this.areaAddress = areaAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
