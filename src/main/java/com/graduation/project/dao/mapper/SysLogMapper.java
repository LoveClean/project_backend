package com.graduation.project.dao.mapper;

import com.graduation.project.dao.entity.SysLog;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKeyWithBLOBs(SysLog record);

    int updateByPrimaryKey(SysLog record);

    @Select("select * from sys_log ORDER BY create_date desc")
    List<SysLog> selectBySysLog();
}