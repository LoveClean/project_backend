package com.graduation.project.service;

import com.graduation.project.util.ResponseEntity;
import com.graduation.project.vo.AreaVo;
import com.graduation.project.vo.CityVo;
import com.graduation.project.vo.ProvinceVo;

import java.util.List;

public interface CityService {
	/**
	 * 根据记录id查询城市
	 * @param id
	 * @return
	 */
	ResponseEntity<CityVo> selectCityById(Integer id);
	/**
	 * 根据城市id查询城市
	 * @param cityId
	 * @return
	 */
	ResponseEntity<CityVo> selectByCityId(String cityId);
    /**
     * 根据省份ID获取该省城市列表
     * @param provinceId
     * @return
     */
	ResponseEntity<List<CityVo>> selectCitiesByProvinceId(String provinceId);
	
	/**
	 * 根据areaId获取地区
	 * @param areaId
	 * @return
	 */
	ResponseEntity<AreaVo> selectByAreaId(String areaId);
	
	/**
	 * 根据provinceId获取省份
	 * @param provinceId
	 * @return
	 */
	ResponseEntity<ProvinceVo> selectByProvinceId(String provinceId);
	
	/**
	 * 根据城市Id获取该市所有县区
	 * @param cityId
	 * @return
	 */
	ResponseEntity<List<AreaVo>> selectAreasByCityId(String cityId);
	
	ResponseEntity<List<ProvinceVo>> selectProvinces();
}
