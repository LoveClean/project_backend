package com.graduation.project.vo;

import java.util.List;

public class CityVo {
	private String cityId;  //城市ID
	private String city;  //城市名称
	private List<AreaVo> areaVoList;  //该市下所有区、县
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<AreaVo> getAreaVoList() {
		return areaVoList;
	}
	public void setAreaVoList(List<AreaVo> areaVoList) {
		this.areaVoList = areaVoList;
	}
	
	

}
