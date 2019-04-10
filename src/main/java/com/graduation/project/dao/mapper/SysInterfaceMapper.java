package com.graduation.project.dao.mapper;

import com.graduation.project.dao.entity.SysInterface;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysInterfaceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysInterface record);

    int insertSelective(SysInterface record);

    SysInterface selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysInterface record);

    int updateByPrimaryKey(SysInterface record);

    @Select("select * from sys_interface where value = #{interfaceUrl}")
    SysInterface selectByValue(@Param("interfaceUrl") String interfaceUrl);
}