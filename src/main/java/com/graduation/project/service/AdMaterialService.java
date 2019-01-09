package com.graduation.project.service;

import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.AdMaterial;
import com.graduation.project.util.ResponseEntity;

import java.util.List;

public interface AdMaterialService {
    ResponseEntity<Integer> deleteByPrimaryKey(Integer id, String updateBy);

    ResponseEntity<Integer> insertSelective(AdMaterial record);

    ResponseEntity<Integer> insertSelectiveList(List<AdMaterial> records);

    ResponseEntity<AdMaterial> selectByPrimaryKey(Integer id);

    PageResponseBean selectList(Integer pageNum, Integer pageSize);

    PageResponseBean selectListBySearch(Integer pageNum, Integer pageSize, Integer adid);

    ResponseEntity<Integer> updateByPrimaryKeySelective(AdMaterial record);

    ResponseEntity<Integer> updateByPrimaryKeySelectiveList(List<AdMaterial> records);
}
