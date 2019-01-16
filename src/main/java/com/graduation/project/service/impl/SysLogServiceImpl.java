package com.graduation.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.Admin;
import com.graduation.project.dao.entity.SysInterface;
import com.graduation.project.dao.entity.SysLog;
import com.graduation.project.dao.mapper.AdminMapper;
import com.graduation.project.dao.mapper.SysInterfaceMapper;
import com.graduation.project.dao.mapper.SysLogMapper;
import com.graduation.project.service.SysLogService;
import com.graduation.project.util.DateUtil;
import com.graduation.project.util.IdGen;
import com.graduation.project.vo.AdminVO;
import com.graduation.project.vo.SysLogVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class SysLogServiceImpl implements SysLogService {
    @Resource
    private SysLogMapper sysLogMapper;
    @Resource
    private AdminMapper adminMapper;
    @Resource
    private SysInterfaceMapper sysInterfaceMapper;

    @Override
    public int add(SysLog sysLog, AdminVO user) {
        sysLog.setId(IdGen.uuid());
        sysLog.setCreateBy(user.getPhone());
        sysLog.setCreateDate(new Date());
        sysLogMapper.insertSelective(sysLog);
        return 0;
    }

    @Override
    public PageResponseBean<SysLogVo> sysLog(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysLog> lists = sysLogMapper.selectBySysLog();
        List<SysLogVo> syslogVos = Lists.newArrayList();
        for (SysLog syslog : lists) {
            SysLogVo syslogVo = assembleSysLogVo(syslog);
            syslogVos.add(syslogVo);
        }
        PageInfo pageInfo = new PageInfo(lists);
        pageInfo.setList(syslogVos);
        return new PageResponseBean<SysLogVo>(pageInfo);
    }
    
    private SysLogVo assembleSysLogVo(SysLog syslog) {
        SysLogVo syslogVo=new SysLogVo();
        syslogVo.setId(syslog.getId());

        Admin user= adminMapper.selectByPhone(syslog.getCreateBy());
        if(user!=null) {
            syslogVo.setAccount(user.getPhone());
            syslogVo.setName(user.getTruename());
        }

        syslogVo.setCreatetime(DateUtil.format(syslog.getCreateDate(),DateUtil.DEFAULT_PATTERN));
        syslogVo.setRemoteIP(syslog.getRemoteAddr());
        syslogVo.setUrl(syslog.getRequestUri());

        if(StringUtils.isNotEmpty(syslog.getRequestUri())) {
            System.out.println(syslog.getRequestUri());
            SysInterface sysinterface= sysInterfaceMapper.selectByValue(syslog.getRequestUri());
            if(sysinterface!=null) {
                syslogVo.setRequesturl(sysinterface.getName());
            }else {
                syslogVo.setRequesturl(syslog.getRequestUri());
            }
        }
        return syslogVo;

    }
}
