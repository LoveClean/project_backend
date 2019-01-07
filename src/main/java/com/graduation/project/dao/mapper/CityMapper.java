package com.graduation.project.dao.mapper;

import com.graduation.project.dao.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CityMapper {

    /**
     * 根据id获取城市
     *
     * @param id
     * @return
     */
    City selectByPrimaryKey(Integer id);

    /**
     * 根据城市id获取城市
     *
     * @param cityId
     * @return
     */
    City selectByCityId(@Param("cityId") String cityId);

    /**
     * 根据省份id,获取该省所有城市
     *
     * @return
     */
    List<City> selectCitiesByProvinceId(@Param("provinceId") String provinceId);
}