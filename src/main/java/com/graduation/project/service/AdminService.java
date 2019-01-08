package com.graduation.project.service;

import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.Admin;
import com.graduation.project.util.ResponseEntity;

public interface AdminService {
    ResponseEntity<Integer> deleteByPrimaryKey(Integer id, String updateBy);

    ResponseEntity<Integer> insertSelective(Admin record);

    ResponseEntity<Admin> selectByPrimaryKey(Integer id);

    PageResponseBean selectList(Integer pageNum, Integer pageSize, String level);

    PageResponseBean selectListByLevel(String level, Integer pageNum, Integer pageSize, String level0);

    ResponseEntity<Integer> updateByPrimaryKeySelective(Admin record);

    ResponseEntity<Integer> updatePasswordById(Integer id, String oldPassword, String newPassword, String updateBy);

    ResponseEntity<Integer> updateStatusById(Integer id, Integer status, String updateBy);

    ResponseEntity<Admin> login(String phone, String password);
}
