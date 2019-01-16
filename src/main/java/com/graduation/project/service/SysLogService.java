package com.graduation.project.service;


import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.SysLog;
import com.graduation.project.vo.AdminVO;
import com.graduation.project.vo.SysLogVo;

public interface SysLogService {

    int add(SysLog sysLog, AdminVO user);

    PageResponseBean<SysLogVo> sysLog(Integer pageNum, Integer pageSize);

//    PageResponseBean<SysLogVo> selectLogbyKey(String account, String email, Integer pageNum, Integer pageSize);

}
