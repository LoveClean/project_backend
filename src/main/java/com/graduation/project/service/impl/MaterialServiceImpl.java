package com.graduation.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.Material;
import com.graduation.project.dao.mapper.MaterialMapper;
import com.graduation.project.service.MaterialService;
import com.graduation.project.util.ResponseEntity;
import com.graduation.project.util.ResponseEntityUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Resource
    private MaterialMapper materialMapper;

    @Override
    public ResponseEntity<Integer> deleteByPrimaryKey(Integer id, String updateBy) {
        return ResponseEntityUtil.success(materialMapper.deleteByPrimaryKey(id, updateBy));
    }

    @Override
    public ResponseEntity<Integer> insertSelective(Material record) {
        return ResponseEntityUtil.success(materialMapper.insertSelective(record));
    }

    @Override
    public ResponseEntity<Material> selectByPrimaryKey(Integer id) {
        return ResponseEntityUtil.success(materialMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResponseBean selectList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Material> MaterialList = materialMapper.selectList();
        PageInfo pageInfo = new PageInfo(MaterialList);
        pageInfo.setList(MaterialList);

        PageResponseBean page = new PageResponseBean<Material>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public PageResponseBean selectListBySearch(String type, String name, String groupId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Material> MaterialList;
        if (groupId.equals("")) {
            MaterialList = materialMapper.selectListByName(type, name);
        } else {
            MaterialList = materialMapper.selectListBySearch(type, name, groupId);
        }
        PageInfo pageInfo = new PageInfo(MaterialList);
        pageInfo.setList(MaterialList);

        PageResponseBean page = new PageResponseBean<Material>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public ResponseEntity<Integer> updateByPrimaryKeySelective(Material record) {
        return ResponseEntityUtil.success(materialMapper.updateByPrimaryKeySelective(record));
    }
}
