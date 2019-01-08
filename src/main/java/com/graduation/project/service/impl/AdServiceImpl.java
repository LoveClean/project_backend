package com.graduation.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.Ad;
import com.graduation.project.dao.entity.AdGroup;
import com.graduation.project.dao.entity.AdMaterial;
import com.graduation.project.dao.entity.Material;
import com.graduation.project.dao.mapper.AdGroupMapper;
import com.graduation.project.dao.mapper.AdMapper;
import com.graduation.project.dao.mapper.AdMaterialMapper;
import com.graduation.project.dao.mapper.MaterialMapper;
import com.graduation.project.service.AdService;
import com.graduation.project.util.ResponseEntity;
import com.graduation.project.util.ResponseEntityUtil;
import com.graduation.project.vo.AdMaterialVO;
import com.graduation.project.vo.AdVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdServiceImpl implements AdService {
    @Resource
    private AdMapper adMapper;
    @Resource
    private AdGroupMapper adGroupMapper;
    @Resource
    private AdMaterialMapper adMaterialMapper;
    @Resource
    private MaterialMapper materialMapper;

    @Override
    public ResponseEntity<Integer> deleteByPrimaryKey(Integer id, String updateBy) {
        int updateCount = adMapper.deleteByPrimaryKey(id, updateBy);
        if (updateCount == 0) {
            return ResponseEntityUtil.fail("广告删除失败");
        }
        return ResponseEntityUtil.success(updateCount);
    }

    @Override
    public ResponseEntity<Integer> insertSelective(Ad record) {
        int resultCount = adMapper.insertSelective(record);
        if (resultCount == 0) {
            return ResponseEntityUtil.fail("广告添加失败");
        }
        return ResponseEntityUtil.success(resultCount);
    }

    @Override
    public ResponseEntity<Ad> selectByPrimaryKey(Integer id) {
        Ad validResponse = adMapper.selectByPrimaryKey(id);
        if (validResponse == null) {
            return ResponseEntityUtil.fail("广告不存在");
        }
        return ResponseEntityUtil.success(validResponse);
    }

    @Override
    public PageResponseBean selectList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Ad> adList = adMapper.selectList();

        List<AdVO> adVOList = Lists.newArrayList();
        for (Ad ad : adList) {
            AdGroup adGroup = adGroupMapper.selectByPrimaryKey(ad.getGroupid());
            List<AdMaterial> adMaterialList = adMaterialMapper.selectListBySearch(ad.getId());

            List adMaterialVOList = Lists.newArrayList();
            for (AdMaterial adMaterial : adMaterialList) {
                Material material = materialMapper.selectByPrimaryKey(adMaterial.getMaterialid());
                AdMaterialVO adMaterialVO = new AdMaterialVO(adMaterial, material);
                adMaterialVOList.add(adMaterialVO);
            }

            AdVO adVO = new AdVO(ad, adGroup, adMaterialVOList);
            adVOList.add(adVO);
        }

        PageInfo pageInfo = new PageInfo(adList);
        pageInfo.setList(adVOList);
        PageResponseBean page = new PageResponseBean<Ad>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public PageResponseBean selectListBySearch(String name, String groupid, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Ad> adList;
        if (groupid.equals("")) {
            adList = adMapper.selectListByName(name);
        } else {
            adList = adMapper.selectListBySearch(name, groupid);
        }

        List<AdVO> adVOList = Lists.newArrayList();
        for (Ad ad : adList) {
            AdGroup adGroup = adGroupMapper.selectByPrimaryKey(ad.getGroupid());
            List<AdMaterial> adMaterialList = adMaterialMapper.selectListBySearch(ad.getId());

            List adMaterialVOList = Lists.newArrayList();
            for (AdMaterial adMaterial : adMaterialList) {
                Material material = materialMapper.selectByPrimaryKey(adMaterial.getMaterialid());
                AdMaterialVO adMaterialVO = new AdMaterialVO(adMaterial, material);
                adMaterialVOList.add(adMaterialVO);
            }

            AdVO adVO = new AdVO(ad, adGroup, adMaterialVOList);
            adVOList.add(adVO);
        }

        PageInfo pageInfo = new PageInfo(adList);
        pageInfo.setList(adList);
        PageResponseBean page = new PageResponseBean<Ad>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public ResponseEntity<Integer> updateByPrimaryKeySelective(Ad record) {
        int updateCount = adMapper.updateByPrimaryKeySelective(record);
        if (updateCount == 0) {
            return ResponseEntityUtil.fail("广告更新失败");
        }
        return ResponseEntityUtil.success(updateCount);
    }
}
