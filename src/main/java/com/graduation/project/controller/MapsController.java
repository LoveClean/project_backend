package com.graduation.project.controller;

import com.graduation.project.controller.request.MapsInsertSelective;
import com.graduation.project.controller.request.MapsUpdateByPrimaryKeySelective;
import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.Maps;
import com.graduation.project.service.MapsService;
import com.graduation.project.util.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(description = "数字地图操作接口", produces = "application/json")
@RestController
@RequestMapping("/maps/")
public class MapsController extends BaseController {
    @Autowired
    private MapsService mapsService;

    @ApiOperation(value = "删除网点", notes = "根据主键删除")
    @DeleteMapping(value = "deleteByPrimaryKey")
    public ResponseEntity<Integer> deleteByPrimaryKey(@RequestParam Integer id, HttpServletRequest request) {
        return mapsService.deleteByPrimaryKey(id, super.getSessionUser(request).getTruename());
    }

    @ApiOperation(value = "添加网点", notes = "添加网点")
    @PostMapping(value = "insertSelective")
    public ResponseEntity<Integer> insertSelective(@Valid @RequestBody MapsInsertSelective bean, HttpServletRequest request) {
        Maps record = new Maps(bean.getName(), bean.getPhone(), bean.getAreaId(), bean.getAddress(), super.getSessionUser(request).getTruename());
        return mapsService.insertSelective(record);
    }

    @ApiOperation(value = "查看网点", notes = "根据主键查看网点")
    @GetMapping(value = "selectByPrimaryKey")
    public ResponseEntity<Maps> selectByPrimaryKey(@RequestParam Integer id) {
        return mapsService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "查看网点列表", notes = "查看网点列表")
    @GetMapping(value = "selectList")
    public PageResponseBean selectList(@RequestParam Integer pageNum, @RequestParam Integer pageSize, HttpServletRequest request) {
        return mapsService.selectList(pageNum, pageSize, super.getSessionUser(request).getLevel());
    }

    @ApiOperation(value = "搜索网点列表", notes = "根据name和areaId查看网点列表")
    @GetMapping(value = "selectListBySearch")
    public PageResponseBean selectListBySearch(@RequestParam String name, @RequestParam String areaId, @RequestParam Integer pageNum, @RequestParam Integer pageSize, HttpServletRequest request) {
        return mapsService.selectListBySearch(name, areaId, pageNum, pageSize, super.getSessionUser(request).getLevel());
    }

    @ApiOperation(value = "修改网点", notes = "修改网点")
    @PutMapping(value = "updateByPrimaryKeySelective")
    public ResponseEntity<Integer> updateByPrimaryKeySelective(@Valid @RequestBody MapsUpdateByPrimaryKeySelective bean, HttpServletRequest request) {
        Maps record = new Maps();
        record.setId(bean.getId());
        record.setName(bean.getName());
        record.setPhone(bean.getPhone());
        record.setAreaId(bean.getAreaId());
        record.setAddress(bean.getAddress());
        record.setUpdateBy(super.getSessionUser(request).getTruename());
        return mapsService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation(value = "查看网点总数", notes = "查看网点总数")
    @GetMapping(value = "selectTotalElements")
    public ResponseEntity<Integer> selectTotalElements(HttpServletRequest request) {
        return mapsService.selectTotalElements(super.getSessionUser(request).getLevel());
    }
}
