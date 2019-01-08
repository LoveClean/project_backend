package com.graduation.project.controller;

import com.graduation.project.controller.request.AdInsertSelective;
import com.graduation.project.controller.request.AdUpdateByPrimaryKeySelective;
import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.Ad;
import com.graduation.project.service.AdService;
import com.graduation.project.util.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(description = "广告操作接口", produces = "application/json")
@RestController
@RequestMapping("/Ad/")
public class AdController extends BaseController {
    @Autowired
    private AdService adService;

    @ApiOperation(value = "删除广告", notes = "1122根据主键删除")
    @DeleteMapping(value = "deleteByPrimaryKey")
    public ResponseEntity<Integer> deleteByPrimaryKey(@RequestParam Integer id, HttpServletRequest request) {
        return adService.deleteByPrimaryKey(id, super.getSessionUser(request).getTruename());
    }

    @ApiOperation(value = "添加广告", notes = "添加广告")
    @PostMapping(value = "insertSelective")
    public ResponseEntity<Integer> insertSelective(@Valid @RequestBody AdInsertSelective bean, HttpServletRequest request) {
        Ad record = new Ad(bean.getName(), bean.getGroupid(), super.getSessionUser(request).getTruename());
        return adService.insertSelective(record);
    }

    @ApiOperation(value = "查看广告", notes = "根据主键查看广告")
    @GetMapping(value = "selectByPrimaryKey")
    public ResponseEntity<Ad> selectByPrimaryKey(@RequestParam Integer id) {
        return adService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "查看广告列表", notes = "查看广告列表")
    @GetMapping(value = "selectList")
    public PageResponseBean selectList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return adService.selectList(pageNum, pageSize);
    }

    @ApiOperation(value = "搜索广告列表", notes = "根据name和groupid查看广告列表")
    @GetMapping(value = "selectListBySearch")
    public PageResponseBean selectListBySearch(@RequestParam String name, @RequestParam String groupid, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return adService.selectListBySearch(name, groupid, pageNum, pageSize);
    }

    @ApiOperation(value = "修改广告", notes = "修改广告")
    @PutMapping(value = "updateByPrimaryKeySelective")
    public ResponseEntity<Integer> updateByPrimaryKeySelective(@Valid @RequestBody AdUpdateByPrimaryKeySelective bean, HttpServletRequest request) {
        Ad record = new Ad();
        record.setId(bean.getId());
        record.setName(bean.getName());
        record.setGroupid(bean.getGroupid());
        record.setUpdateBy(super.getSessionUser(request).getTruename());
        return adService.updateByPrimaryKeySelective(record);
    }
}
