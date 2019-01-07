package com.graduation.project.service;

import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.AdMaterial;
import com.graduation.project.util.ResponseEntity;

public interface AdMaterialService {
    ResponseEntity<Integer> deleteByPrimaryKey(Integer id, String updateBy);

    ResponseEntity<Integer> insertSelective(AdMaterial record);

    ResponseEntity<AdMaterial> selectByPrimaryKey(Integer id);

    PageResponseBean selectList(Integer pageNum, Integer pageSize);

    ResponseEntity<Integer> updateByPrimaryKeySelective(AdMaterial record);
}
