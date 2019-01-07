package com.graduation.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.graduation.project.contants.Errors;
import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.Admin;
import com.graduation.project.dao.mapper.AdminMapper;
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
    @Autowired
    private CityService cityService;

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
    public PageResponseBean selectList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> adminList = adminMapper.selectList();

        List<AdminVO> adminVOList = Lists.newArrayList();
        for (Admin admin : adminList) {
            ResponseEntity levelAddress;
            String levelNmae = "未知管理员";
            if (admin.getLevel().length() == 2) {
                levelAddress = cityService.selectByProvinceId(admin.getLevel() + "0000");
                levelNmae = "省级管理员";
            } else if (admin.getLevel().length() == 4) {
                levelAddress = cityService.selectByCityId(admin.getLevel() + "00");
                levelNmae = "市级管理员";
            } else if (admin.getLevel().length() == 6) {
                levelAddress = cityService.selectByAreaId(admin.getLevel());
                levelNmae = "区域管理员";
            } else {
                levelAddress = cityService.selectByAreaId(admin.getLevel());
                levelNmae = "超级管理员";
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

    @Override
    public PageResponseBean selectListByLevel(String level, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> admins = adminMapper.selectListByLevel(level);
        PageInfo pageInfo = new PageInfo(admins);
        pageInfo.setList(admins);

        PageResponseBean page = new PageResponseBean<Admin>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
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
}
