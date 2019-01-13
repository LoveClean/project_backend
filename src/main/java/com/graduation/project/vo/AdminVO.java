package com.graduation.project.vo;

import com.graduation.project.dao.entity.Admin;
import com.graduation.project.util.ResponseEntity;

public class AdminVO {
    private Integer id;
    private String truename;
    private String phone;
    private String level;
    private Byte status;
    private String createBy;
    private String levelAddress;// 管辖地址
    private String levelName;
    private String accessToken;// 登录token
    public AdminVO() {
    }

    public AdminVO(Admin admin, String levelAddress, String levelName) {
        this.id = admin.getId();
        this.truename = admin.getTruename();
        this.phone = admin.getPhone();
        this.level = admin.getLevel();
        this.status = admin.getStatus();
        this.createBy = admin.getCreateBy();
        this.levelAddress = levelAddress;
        this.levelName = levelName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getLevelAddress() {
        return levelAddress;
    }

    public void setLevelAddress(String levelAddress) {
        this.levelAddress = levelAddress;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelNmae) {
        this.levelName = levelNmae;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
