package com.graduation.project.controller.request;

public class AdMaterialInsertSelective {
    private Integer adid;

    private Integer materialid;

    private Integer orderindex;

    private Integer loadstep;

    private Integer displaytime;

    private String musicpath;

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
}
