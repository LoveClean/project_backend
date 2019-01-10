package com.graduation.project.vo;

import com.graduation.project.dao.entity.AdDelivery;
import com.graduation.project.util.ResponseEntity;

import java.util.Date;

public class AdDeliveryVO {
    private Integer id;
    private Integer adId;
    private Integer priority;
    private String areaId;
    private String addressId;
    private Date beginTime;
    private Date endTime;
    private String createBy;
    private String areaAddress;
    private String addressName;

    public AdDeliveryVO() {
    }

    public AdDeliveryVO(AdDelivery adDelivery, String areaAddress, String addressName) {
        this.id = adDelivery.getId();
        this.adId = adDelivery.getAdId();
        this.priority = adDelivery.getPriority();
        this.areaId = adDelivery.getAreaId();
        this.addressId = adDelivery.getAddressId();
        this.beginTime = adDelivery.getBeginTime();
        this.endTime = adDelivery.getEndTime();
        this.createBy = adDelivery.getCreateBy();
        this.areaAddress = areaAddress;
        this.addressName = addressName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAreaAddress() {
        return areaAddress;
    }

    public void setAreaAddress(String areaAddress) {
        this.areaAddress = areaAddress;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
