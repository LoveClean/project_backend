package com.graduation.project.service;

import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.Material;
import com.graduation.project.util.ResponseEntity;

public interface MaterialService {
    ResponseEntity<Integer> deleteByPrimaryKey(Integer id, String updateBy);

    ResponseEntity<Integer> insertSelective(Material record);

    ResponseEntity<Material> selectByPrimaryKey(Integer id);

    PageResponseBean selectList(Integer pageNum, Integer pageSize);

    PageResponseBean selectListBySearch(String name, String groupId, Integer pageNum, Integer pageSize);

    ResponseEntity<Integer> updateByPrimaryKeySelective(Material record);
}
