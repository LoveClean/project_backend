package com.graduation.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.Material;
import com.graduation.project.dao.entity.MaterialGroup;
import com.graduation.project.dao.mapper.MaterialGroupMapper;
import com.graduation.project.service.MaterialGroupService;
import com.graduation.project.util.ResponseEntity;
import com.graduation.project.util.ResponseEntityUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MaterialGroupServiceImpl implements MaterialGroupService {
    @Resource
    private MaterialGroupMapper materialGroupMapper;

    @Override
    public ResponseEntity<Integer> deleteByPrimaryKey(Integer id, String updateBy) {
        return ResponseEntityUtil.success(materialGroupMapper.deleteByPrimaryKey(id, updateBy));
    }

    @Override
    public ResponseEntity<Integer> insertSelective(MaterialGroup record) {
        return ResponseEntityUtil.success(materialGroupMapper.insertSelective(record));
    }

    @Override
    public ResponseEntity<MaterialGroup> selectByPrimaryKey(Integer id) {
        return ResponseEntityUtil.success(materialGroupMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResponseBean selectList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<MaterialGroup> MaterialList = materialGroupMapper.selectList();
        PageInfo pageInfo = new PageInfo(MaterialList);
        pageInfo.setList(MaterialList);

        PageResponseBean page = new PageResponseBean<Material>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public PageResponseBean selectListBySearch(String name, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<MaterialGroup> MaterialList = materialGroupMapper.selectListBySearch(name);
        PageInfo pageInfo = new PageInfo(MaterialList);
        pageInfo.setList(MaterialList);

        PageResponseBean page = new PageResponseBean<Material>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public ResponseEntity<Integer> updateByPrimaryKeySelective(MaterialGroup record) {
        return ResponseEntityUtil.success(materialGroupMapper.updateByPrimaryKeySelective(record));
    }
}
