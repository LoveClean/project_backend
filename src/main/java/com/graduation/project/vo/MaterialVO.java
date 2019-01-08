package com.graduation.project.vo;

import com.graduation.project.dao.entity.Material;

public class MaterialVO {
    private Integer id;
    private String name;
    private String type;
    private Integer groupId;
    private String path;
    private String groupName;

    public MaterialVO() {
    }

    public MaterialVO(Material material, String groupName) {
        this.id = material.getId();
        this.name = material.getName();
        this.type = material.getType();
        this.groupId = material.getGroupId();
        this.path = material.getPath();
        this.groupName = groupName;
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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
