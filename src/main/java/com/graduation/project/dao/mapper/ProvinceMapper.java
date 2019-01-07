package com.graduation.project.dao.mapper;

import com.graduation.project.dao.entity.Province;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProvinceMapper {

    /**
     * 根据省份id获取省份
     *
     * @param id
     * @return 省份
     */
    Province selectByPrimaryKey(Integer id);

    /**
     * 获取所有省份
     *
     * @return
     */
    List<Province> selectAllProvinces();

    Province selectByProvinceId(@Param("provinceId") String provinceId);

}