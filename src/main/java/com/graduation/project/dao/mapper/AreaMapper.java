package com.graduation.project.dao.mapper;

import com.graduation.project.dao.entity.Area;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaMapper {


    Area selectByPrimaryKey(Integer id);

    Area selectByAreaId(@Param("areaId") String areaId);

    List<Area> selectAreasByCityId(@Param("cityId") String cityId);

}