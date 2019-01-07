package com.graduation.project.service;

import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.Maps;
import com.graduation.project.util.ResponseEntity;

public interface MapsService {
    ResponseEntity<Integer> deleteByPrimaryKey(Integer id, String updateBy);

    ResponseEntity<Integer> insertSelective(Maps record);

    ResponseEntity<Maps> selectByPrimaryKey(Integer id);

    PageResponseBean selectList(Integer pageNum, Integer pageSize);

    PageResponseBean selectListBySearch(String name, String areaId, Integer pageNum, Integer pageSize);

    ResponseEntity<Integer> updateByPrimaryKeySelective(Maps record);
}
