package com.graduation.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.Maps;
import com.graduation.project.dao.mapper.MapsMapper;
import com.graduation.project.service.CityService;
import com.graduation.project.service.MapsService;
import com.graduation.project.util.ResponseEntity;
import com.graduation.project.util.ResponseEntityUtil;
import com.graduation.project.vo.AreaVo;
import com.graduation.project.vo.MapsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MapsServiceImpl implements MapsService {
    @Resource
    private MapsMapper mapsMapper;
    @Autowired
    private CityService cityService;

    @Override
    public ResponseEntity<Integer> deleteByPrimaryKey(Integer id, String updateBy) {
        int updateCount = mapsMapper.deleteByPrimaryKey(id, updateBy);
        if (updateCount == 0) {
            return ResponseEntityUtil.fail("网点删除失败");
        }
        return ResponseEntityUtil.success(updateCount);
    }

    @Override
    public ResponseEntity<Integer> insertSelective(Maps record) {
        //校验
        Maps validResponse = mapsMapper.selectByName(record.getName());
        if (validResponse != null) {
            return ResponseEntityUtil.fail("此网点名称已存在");
        }
        validResponse = mapsMapper.selectByAddress(record.getAddress());
        if (validResponse != null) {
            return ResponseEntityUtil.fail("此网点地址已存在");
        }

        int resultCount = mapsMapper.insertSelective(record);
        if (resultCount == 0) {
            return ResponseEntityUtil.fail("网点添加失败");
        }

        return ResponseEntityUtil.success(resultCount);
    }

    @Override
    public ResponseEntity<Maps> selectByPrimaryKey(Integer id) {
        //校验
        Maps validResponse = mapsMapper.selectByPrimaryKey(id);
        if (validResponse == null) {
            return ResponseEntityUtil.fail("网点不存在");
        }
        return ResponseEntityUtil.success(validResponse);
    }

    @Override
    public PageResponseBean selectList(Integer pageNum, Integer pageSize, String level) {
        PageHelper.startPage(pageNum, pageSize);
        int number = level.length();
        List<Maps> mapsList = mapsMapper.selectList(level, number);

        List<MapsVO> mapsVOList = Lists.newArrayList();
        for (Maps maps : mapsList) {
            ResponseEntity<AreaVo> areaAddress = cityService.selectByAreaId(maps.getAreaId());
            MapsVO mapsVO = new MapsVO(maps, areaAddress);
            mapsVOList.add(mapsVO);
        }

        PageInfo pageInfo = new PageInfo(mapsList);
        pageInfo.setList(mapsVOList);
        PageResponseBean page = new PageResponseBean<Maps>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public PageResponseBean selectListBySearch(String name, String areaId, Integer pageNum, Integer pageSize, String level) {
        PageHelper.startPage(pageNum, pageSize);
        int number = level.length();
        List<Maps> mapsList = mapsMapper.selectListBySearch(name, areaId,level, number);

        List<MapsVO> mapsVOList = Lists.newArrayList();
        for (Maps maps : mapsList) {
            ResponseEntity<AreaVo> areaAddress = cityService.selectByAreaId(maps.getAreaId());
            MapsVO mapsVO = new MapsVO(maps, areaAddress);
            mapsVOList.add(mapsVO);
        }

        PageInfo pageInfo = new PageInfo(mapsList);
        pageInfo.setList(mapsVOList);
        PageResponseBean page = new PageResponseBean<Maps>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public ResponseEntity<Integer> updateByPrimaryKeySelective(Maps record) {
        //校验
        Maps validResponse = mapsMapper.selectByName(record.getName());
        if (validResponse != null) {
            return ResponseEntityUtil.fail("此网点名称已存在");
        }
        validResponse = mapsMapper.selectByAddress(record.getAddress());
        if (validResponse != null) {
            return ResponseEntityUtil.fail("此网点地址已存在");
        }

        int updateCount = mapsMapper.updateByPrimaryKeySelective(record);
        if (updateCount == 0) {
            return ResponseEntityUtil.fail("网点更新失败");
        }
        return ResponseEntityUtil.success(updateCount);
    }
}
