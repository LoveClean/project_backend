package com.graduation.project.service;

import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.AdGroup;
import com.graduation.project.util.ResponseEntity;

public interface AdGroupService {
    ResponseEntity<Integer> deleteByPrimaryKey(Integer id, String updateBy);

    ResponseEntity<Integer> insertSelective(AdGroup record);

    ResponseEntity<AdGroup> selectByPrimaryKey(Integer id);

    PageResponseBean selectList(Integer pageNum, Integer pageSize);

    PageResponseBean selectListBySearch(String name, Integer pageNum, Integer pageSize);

    ResponseEntity<Integer> updateByPrimaryKeySelective(AdGroup record);
}
