package com.graduation.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.graduation.project.contants.Errors;
import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.Admin;
import com.graduation.project.dao.mapper.AdminMapper;
import com.graduation.project.dao.mapper.AreaMapper;
import com.graduation.project.dao.mapper.CityMapper;
import com.graduation.project.dao.mapper.ProvinceMapper;
import com.graduation.project.service.AdminService;
import com.graduation.project.service.CityService;
import com.graduation.project.util.MD5Util;
import com.graduation.project.util.ResponseEntity;
import com.graduation.project.util.ResponseEntityUtil;
import com.graduation.project.util.StringUtil;
import com.graduation.project.vo.AdminVO;
import com.graduation.project.vo.AreaVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    @Resource
    private ProvinceMapper provinceMapper;
    @Resource
    private CityMapper cityMapper;
    @Resource
    private AreaMapper areaMapper;

    @Override
    public ResponseEntity<Integer> deleteByPrimaryKey(Integer id, String updateBy) {
        int updateCount = adminMapper.deleteByPrimaryKey(id, updateBy);
        if (updateCount == 0) {
            return ResponseEntityUtil.fail("管理员删除失败");
        }
        return ResponseEntityUtil.success(updateCount);
    }

    @Override
    public ResponseEntity<Integer> insertSelective(Admin record) {
        //校验
        Admin validResponse = adminMapper.selectByPhone(record.getPhone());
        if (validResponse != null) {
            return ResponseEntityUtil.fail("此账号已存在");
        }
        //密码通过MD5加密
        record.setPassword(MD5Util.MD5(record.getPassword()));
        int resultCount = adminMapper.insertSelective(record);
        if (resultCount == 0) {
            return ResponseEntityUtil.fail("添加管理员失败");
        }

        return ResponseEntityUtil.success(resultCount);
    }

    @Override
    public ResponseEntity<Admin> selectByPrimaryKey(Integer id) {
        //校验
        Admin validResponse = adminMapper.selectByPrimaryKey(id);
        if (validResponse == null) {
            return ResponseEntityUtil.fail("账号不存在");
        }
        return ResponseEntityUtil.success(validResponse);
    }

    @Override
    public PageResponseBean selectList(Integer pageNum, Integer pageSize, String level) {
        PageHelper.startPage(pageNum, pageSize);
        int number = level.length();
        List<Admin> adminList = adminMapper.selectList(level, number);

//        List<AdminVO> adminVOList = Lists.newArrayList();
//        for (Admin admin : adminList) {
//            String adminLevel = admin.getLevel();
//            int adminLevelLength = adminLevel.length();
//            String levelAddress = "全国";
//            String levelNmae = "全国管理员";
//            if (adminLevelLength == 2) {
//                levelAddress = provinceMapper.selectByProvinceId(adminLevel + "0000").getProvince();
//                levelNmae = "省级管理员";
//            } else if (adminLevelLength == 4) {
//                levelAddress = provinceMapper.selectByProvinceId(adminLevel.substring(0, 2) + "0000").getProvince() + cityMapper.selectByCityId(adminLevel.substring(0, 4) + "00").getCity();
//                levelNmae = "市级管理员";
//            } else if (adminLevelLength == 6) {
//                levelAddress = provinceMapper.selectByProvinceId(adminLevel.substring(0, 2) + "0000").getProvince() + cityMapper.selectByCityId(adminLevel.substring(0, 4) + "00").getCity() + areaMapper.selectByAreaId(adminLevel).getArea();
//                levelNmae = "区域管理员";
//            }
//            AdminVO adminVO = new AdminVO(admin, levelAddress, levelNmae);
//            adminVOList.add(adminVO);
//        }
//
//        PageInfo pageInfo = new PageInfo(adminList);
//        pageInfo.setList(adminVOList);
//        PageResponseBean page = new PageResponseBean<Admin>(pageInfo);
//        page.setCode(0);
//        page.setHttpStatus(200);
//        return page;
        return adminList(adminList);
    }

    @Override
    public PageResponseBean selectListByLevel(String level, Integer pageNum, Integer pageSize, String level0) {
        PageHelper.startPage(pageNum, pageSize);
        int number = level.length();
        List<Admin> adminList = adminMapper.selectListByLevel(level, level0, number);

//        List<AdminVO> adminVOList = Lists.newArrayList();
//        for (Admin admin : adminList) {
//            String adminLevel = admin.getLevel();
//            int adminLevelLength = adminLevel.length();
//            String levelAddress = "全国";
//            String levelNmae = "全国管理员";
//            if (adminLevelLength == 2) {
//                levelAddress = provinceMapper.selectByProvinceId(adminLevel + "0000").getProvince();
//                levelNmae = "省级管理员";
//            } else if (adminLevelLength == 4) {
//                levelAddress = provinceMapper.selectByProvinceId(adminLevel.substring(0, 2) + "0000").getProvince() + cityMapper.selectByCityId(adminLevel.substring(0, 4) + "00").getCity();
//                levelNmae = "市级管理员";
//            } else if (adminLevelLength == 6) {
//                levelAddress = provinceMapper.selectByProvinceId(adminLevel.substring(0, 2) + "0000").getProvince() + cityMapper.selectByCityId(adminLevel.substring(0, 4) + "00").getCity() + areaMapper.selectByAreaId(adminLevel).getArea();
//                levelNmae = "区域管理员";
//            }
//            AdminVO adminVO = new AdminVO(admin, levelAddress, levelNmae);
//            adminVOList.add(adminVO);
//        }
//
//        PageInfo pageInfo = new PageInfo(adminList);
//        pageInfo.setList(adminList);
//        PageResponseBean page = new PageResponseBean<Admin>(pageInfo);
//        page.setCode(0);
//        page.setHttpStatus(200);
//        return page;
        return adminList(adminList);
    }

    @Override
    public ResponseEntity<Integer> updateByPrimaryKeySelective(Admin record) {
        //校验
        Admin validResponse = adminMapper.selectByPhone(record.getPhone());
        if (validResponse != null && !validResponse.getId().equals(record.getId())) {
            return ResponseEntityUtil.fail("此账号已存在");
        }
        //如果更改密码，则将密码通过MD5加密
        if (!StringUtil.isEmpty(record.getPassword())) {
            record.setPassword(MD5Util.MD5(record.getPassword()));
        }
        int updateCount = adminMapper.updateByPrimaryKeySelective(record);
        if (updateCount == 0) {
            return ResponseEntityUtil.fail("更新个人信息失败");
        }
        return ResponseEntityUtil.success(updateCount);
    }

    @Override
    public ResponseEntity<Integer> updatePasswordById(Integer id, String oldPassword, String newPassword, String updateBy) {
        String MD5OldPassword = MD5Util.MD5(oldPassword);
        String MD5NewPassword = MD5Util.MD5(newPassword);
        int updateCount = adminMapper.updatePasswordById(id, MD5OldPassword, MD5NewPassword, updateBy);
        if (updateCount == 0) {
            return ResponseEntityUtil.fail("原密码有误");
        }
        return ResponseEntityUtil.success(updateCount);
    }

    @Override
    public ResponseEntity<Integer> updateStatusById(Integer id, Integer status, String updateBy) {
        int updateCount = adminMapper.updateStatusById(id, status, updateBy);
        if (updateCount == 0) {
            return ResponseEntityUtil.fail("状态修改失败");
        }
        return ResponseEntityUtil.success(updateCount);
    }

    @Override
    public ResponseEntity<Admin> login(String phone, String password) {
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(password)) {
            return ResponseEntityUtil.fail(Errors.SYSTEM_REQUEST_PARAM_ERROR);
        }

        Admin user = null;
        String MD5Password = MD5Util.MD5(password);

        user = adminMapper.login(phone, MD5Password);

        if (user == null) {
            return ResponseEntityUtil.fail("账号或密码错误");
        }

        if (user.getStatus() == 0) {
            return ResponseEntityUtil.fail("该账号已被禁用");
        }

//		if(this.checkUserStatus(user).isSuccess()) {
//			user.setPassword(StringUtils.EMPTY);
//			return ResponseEntityUtil.success(user);
//		}else {
//			return ResponseEntityUtil.fail(Errors.SYSTEM_NO_ACCESS);
//		}

//        user.setPassword(StringUtils.EMPTY);
        return ResponseEntityUtil.success(user);
    }


    private PageResponseBean adminList(List<Admin> adminList) {
        List<AdminVO> adminVOList = Lists.newArrayList();
        for (Admin admin : adminList) {
            String adminLevel = admin.getLevel();
            int adminLevelLength = adminLevel.length();
            String levelAddress = "全国";
            String levelNmae = "全国管理员";
            if (adminLevelLength == 2) {
                levelAddress = provinceMapper.selectByProvinceId(adminLevel + "0000").getProvince();
                levelNmae = "省级管理员";
            } else if (adminLevelLength == 4) {
                levelAddress = provinceMapper.selectByProvinceId(adminLevel.substring(0, 2) + "0000").getProvince() + cityMapper.selectByCityId(adminLevel.substring(0, 4) + "00").getCity();
                levelNmae = "市级管理员";
            } else if (adminLevelLength == 6) {
                levelAddress = provinceMapper.selectByProvinceId(adminLevel.substring(0, 2) + "0000").getProvince() + cityMapper.selectByCityId(adminLevel.substring(0, 4) + "00").getCity() + areaMapper.selectByAreaId(adminLevel).getArea();
                levelNmae = "区域管理员";
            }
            AdminVO adminVO = new AdminVO(admin, levelAddress, levelNmae);
            adminVOList.add(adminVO);
        }

        PageInfo pageInfo = new PageInfo(adminList);
        pageInfo.setList(adminVOList);
        PageResponseBean page = new PageResponseBean<Admin>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }
}
