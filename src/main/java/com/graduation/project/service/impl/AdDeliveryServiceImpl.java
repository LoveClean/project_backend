package com.graduation.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.AdDelivery;
import com.graduation.project.dao.mapper.AdDeliveryMapper;
import com.graduation.project.service.AdDeliveryService;
import com.graduation.project.service.CityService;
import com.graduation.project.util.ResponseEntity;
import com.graduation.project.util.ResponseEntityUtil;
import com.graduation.project.vo.AdDeliveryVO;
import com.graduation.project.vo.AreaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdDeliveryServiceImpl implements AdDeliveryService {
    @Resource
    private AdDeliveryMapper adDeliveryMapper;
    @Autowired
    private CityService cityService;

    @Override
    public ResponseEntity<Integer> deleteByPrimaryKey(Integer id, String updateBy) {
        int updateCount = adDeliveryMapper.deleteByPrimaryKey(id, updateBy);
        if (updateCount == 0) {
            return ResponseEntityUtil.fail("投放记录删除失败");
        }
        return ResponseEntityUtil.success(updateCount);
    }

    @Override
    public ResponseEntity<Integer> insertSelective(AdDelivery record) {
        int resultCount = adDeliveryMapper.insertSelective(record);
        if (resultCount == 0) {
            return ResponseEntityUtil.fail("投放记录添加失败");
        }
        return ResponseEntityUtil.success(resultCount);
    }

    @Override
    public ResponseEntity<AdDelivery> selectByPrimaryKey(Integer id) {
        AdDelivery validResponse = adDeliveryMapper.selectByPrimaryKey(id);
        if (validResponse == null) {
            return ResponseEntityUtil.fail("投放记录不存在");
        }
        return ResponseEntityUtil.success(validResponse);
    }

    @Override
    public PageResponseBean selectList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AdDelivery> adDeliveryList = adDeliveryMapper.selectList();


        List<AdDeliveryVO> adDeliveryVOList = Lists.newArrayList();
        for (AdDelivery adDelivery : adDeliveryList) {
            ResponseEntity<AreaVo> areaAddress = cityService.selectByAreaId(adDelivery.getAreaId());
            AdDeliveryVO adDeliveryVO = new AdDeliveryVO(adDelivery, areaAddress,"暂时不做");
            adDeliveryVOList.add(adDeliveryVO);
        }

        PageInfo pageInfo = new PageInfo(adDeliveryList);
        pageInfo.setList(adDeliveryVOList);
        PageResponseBean page = new PageResponseBean<AdDelivery>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public ResponseEntity<Integer> updateByPrimaryKeySelective(AdDelivery record) {
        int updateCount = adDeliveryMapper.updateByPrimaryKeySelective(record);
        if (updateCount == 0) {
            return ResponseEntityUtil.fail("投放记录更新失败");
        }
        return ResponseEntityUtil.success(updateCount);
    }
}
