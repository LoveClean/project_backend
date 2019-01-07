package com.graduation.project.controller;

import com.graduation.project.service.CityService;
import com.graduation.project.util.ResponseEntity;
import com.graduation.project.vo.AreaVo;
import com.graduation.project.vo.CityVo;
import com.graduation.project.vo.ProvinceVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "省市区操作接口描述", produces = "application/json")
@RestController
@RequestMapping("/area/")
public class AreaController {
    @Autowired
    private CityService cityService;

    @ApiOperation(value = "查找城市接口", notes = "根据id查找城市")
    @PostMapping(value = "get_city.do")
    public ResponseEntity<CityVo> getCity(@RequestBody Integer id) {
        return cityService.selectCityById(id);
    }

    @ApiOperation(value = "根据cityId查找城市接口", notes = "根据cityId查找城市")
    @PostMapping(value = "get_by_cityId.do")
    public ResponseEntity<CityVo> getByCityId(@RequestBody String cityId) {
        return cityService.selectByCityId(cityId);
    }

    @ApiOperation(value = "根据provinceId查找省份接口", notes = "根据provinceId查找省份")
    @PostMapping(value = "get_by_provinceId.do")
    public ResponseEntity<ProvinceVo> getByProvinceId(@RequestBody String provinceId) {
        return cityService.selectByProvinceId(provinceId);
    }

    //
    @ApiOperation(value = "获取所有城市接口", notes = "根据省份获取所有城市")
    @PostMapping(value = "get_city_list.do")
    public ResponseEntity<List<CityVo>> getCityList(@RequestBody String provinceId) {
        return cityService.selectCitiesByProvinceId(provinceId);
    }

    //
    @ApiOperation(value = "根据areaId查找城市接口", notes = "根据areaId查找城市")
    @PostMapping(value = "get_by_areaId.do")
    public ResponseEntity<AreaVo> getByAreaId(@RequestBody String areaId) {
        return cityService.selectByAreaId(areaId);
    }

    //
    @ApiOperation(value = "获取所有县区接口", notes = "根据城市Id获取所有县区")
    @PostMapping(value = "get_Area_list.do")
    public ResponseEntity<List<AreaVo>> getAreaList(@RequestBody String cityId) {
        return cityService.selectAreasByCityId(cityId);
    }

    //
    @ApiOperation(value = "获取所有省份接口", notes = "获取所有省份")
    @PostMapping(value = "get_Province_list.do")
    public ResponseEntity<List<ProvinceVo>> getProvinceList() {
        return cityService.selectProvinces();
    }

}
