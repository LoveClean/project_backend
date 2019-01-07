package com.graduation.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.AdGroup;
import com.graduation.project.dao.mapper.AdGroupMapper;
import com.graduation.project.service.AdGroupService;
import com.graduation.project.util.ResponseEntity;
import com.graduation.project.util.ResponseEntityUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdGroupServiceImpl implements AdGroupService {
    @Resource
    private AdGroupMapper adGroupMapper;

    @Override
    public ResponseEntity<Integer> deleteByPrimaryKey(Integer id, String updateBy) {
        int updateCount = adGroupMapper.deleteByPrimaryKey(id, updateBy);
        if (updateCount == 0) {
            return ResponseEntityUtil.fail("广告分组删除失败");
        }
        return ResponseEntityUtil.success(updateCount);
    }

    @Override
    public ResponseEntity<Integer> insertSelective(AdGroup record) {
        int resultCount = adGroupMapper.insertSelective(record);
        if (resultCount == 0) {
            return ResponseEntityUtil.fail("广告分组添加失败");
        }
        return ResponseEntityUtil.success(resultCount);
    }

    @Override
    public ResponseEntity<AdGroup> selectByPrimaryKey(Integer id) {
        AdGroup validResponse = adGroupMapper.selectByPrimaryKey(id);
        if (validResponse == null) {
            return ResponseEntityUtil.fail("广告分组不存在");
        }
        return ResponseEntityUtil.success(validResponse);
    }

    @Override
    public PageResponseBean selectList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AdGroup> mapsList = adGroupMapper.selectList();
        PageInfo pageInfo = new PageInfo(mapsList);
        pageInfo.setList(mapsList);

        PageResponseBean page = new PageResponseBean<AdGroupMapper>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public PageResponseBean selectListBySearch(String name, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AdGroup> mapsList = adGroupMapper.selectListBySearch(name);
        PageInfo pageInfo = new PageInfo(mapsList);
        pageInfo.setList(mapsList);

        PageResponseBean page = new PageResponseBean<AdGroupMapper>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public ResponseEntity<Integer> updateByPrimaryKeySelective(AdGroup record) {
        int updateCount = adGroupMapper.updateByPrimaryKeySelective(record);
        if (updateCount == 0) {
            return ResponseEntityUtil.fail("广告分组更新失败");
        }
        return ResponseEntityUtil.success(updateCount);
    }
}
