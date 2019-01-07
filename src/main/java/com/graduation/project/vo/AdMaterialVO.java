package com.graduation.project.vo;

import com.graduation.project.dao.entity.AdMaterial;
import com.graduation.project.dao.entity.Material;

public class AdMaterialVO {
    private Integer id;

    private Integer adid;

    private Integer materialid;

    private Integer orderindex;

    private Integer loadstep;

    private Integer displaytime;

    private String musicpath;

    private String name;

    private String type;

    private Integer groupId;

    private String path;

    public AdMaterialVO() {

    }

    public AdMaterialVO(AdMaterial adMaterial, Material material) {
        this.id = adMaterial.getId();
        this.adid = adMaterial.getAdid();
        this.materialid = adMaterial.getMaterialid();
        this.orderindex = adMaterial.getOrderindex();
        this.loadstep = adMaterial.getLoadstep();
        this.displaytime = adMaterial.getDisplaytime();
        this.musicpath = adMaterial.getMusicpath();
        this.name = material.getName();
        this.type = material.getType();
        this.groupId = material.getGroupId();
        this.path = material.getPath();
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
        this.musicpath = musicpath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
