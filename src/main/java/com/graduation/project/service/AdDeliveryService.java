package com.graduation.project.service;

import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.AdDelivery;
import com.graduation.project.util.ResponseEntity;

public interface AdDeliveryService {
    ResponseEntity<Integer> deleteByPrimaryKey(Integer id, String updateBy);

    ResponseEntity<Integer> insertSelective(AdDelivery record);

    ResponseEntity<AdDelivery> selectByPrimaryKey(Integer id);

    PageResponseBean selectList(Integer pageNum, Integer pageSize);

    ResponseEntity<Integer> updateByPrimaryKeySelective(AdDelivery record);
}
