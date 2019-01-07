package com.graduation.project.dao.entity;

import java.util.Date;

public class AdMaterial {
    private Integer id;

    private Integer adid;

    private Integer materialid;

    private Integer orderindex;

    private Integer loadstep;

    private Integer displaytime;

    private String musicpath;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    public AdMaterial() {
    }

    public AdMaterial(Integer adid, Integer materialid, Integer orderindex, Integer loadstep, Integer displaytime, String musicpath, String createBy) {
        this.adid = adid;
        this.materialid = materialid;
        this.orderindex = orderindex;
        this.loadstep = loadstep;
        this.displaytime = displaytime;
        this.musicpath = musicpath;
        this.createBy = createBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdid() {
        return adid;
    }

    public void setAdid(Integer adid) {
        this.adid = adid;
    }

    public Integer getMaterialid() {
        return materialid;
    }

    public void setMaterialid(Integer materialid) {
        this.materialid = materialid;
    }

    public Integer getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }

    public Integer getLoadstep() {
        return loadstep;
    }

    public void setLoadstep(Integer loadstep) {
        this.loadstep = loadstep;
    }

    public Integer getDisplaytime() {
        return displaytime;
    }

    public void setDisplaytime(Integer displaytime) {
        this.displaytime = displaytime;
    }

    public String getMusicpath() {
        return musicpath;
    }

    public void setMusicpath(String musicpath) {
        this.musicpath = musicpath == null ? null : musicpath.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
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
        this.updateBy = updateBy == null ? null : updateBy.trim();
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
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}