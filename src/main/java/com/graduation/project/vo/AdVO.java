package com.graduation.project.vo;

import com.graduation.project.dao.entity.Ad;
import com.graduation.project.dao.entity.AdGroup;

import java.util.List;

public class AdVO {
    private Integer id;
    private String name;
    private AdGroup adGroup;
    private List adMaterialVO;

    public AdVO() {
    }

    public AdVO(Ad ad, AdGroup adGroup, List adMaterialVO) {
        this.id = ad.getId();
        this.name = ad.getName();
        this.adGroup = adGroup;
        this.adMaterialVO = adMaterialVO;
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

    public AdGroup getAdGroup() {
        return adGroup;
    }

    public void setAdGroup(AdGroup adGroup) {
        this.adGroup = adGroup;
    }

    public List getAdMaterialVO() {
        return adMaterialVO;
    }

    public void setAdMaterialVO(List adMaterialVO) {
        this.adMaterialVO = adMaterialVO;
    }
}
