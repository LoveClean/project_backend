package com.graduation.project.controller;

import com.graduation.project.controller.request.AdGroupInsertSelective;
import com.graduation.project.controller.request.AdGroupUpdateByPrimaryKeySelective;
import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.AdGroup;
import com.graduation.project.service.AdGroupService;
import com.graduation.project.util.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(description = "广告分组操作接口", produces = "application/json")
@RestController
@RequestMapping("/AdGroup/")
public class AdGroupController extends BaseController {
    @Autowired
    private AdGroupService adGroupService;

    @ApiOperation(value = "删除广告分组", notes = "根据主键删除")
    @DeleteMapping(value = "deleteByPrimaryKey")
    public ResponseEntity<Integer> deleteByPrimaryKey(@RequestParam Integer id, HttpServletRequest request) {
        return adGroupService.deleteByPrimaryKey(id, super.getSessionUser(request).getTruename());
    }

    @ApiOperation(value = "添加广告分组", notes = "添加广告分组")
    @PostMapping(value = "insertSelective")
    public ResponseEntity<Integer> insertSelective(@Valid @RequestBody AdGroupInsertSelective bean, HttpServletRequest request) {
        AdGroup record = new AdGroup(bean.getName(), super.getSessionUser(request).getTruename());
        return adGroupService.insertSelective(record);
    }

    @ApiOperation(value = "查看广告分组", notes = "根据主键查看广告分组")
    @GetMapping(value = "selectByPrimaryKey")
    public ResponseEntity<AdGroup> selectByPrimaryKey(@RequestParam Integer id) {
        return adGroupService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "查看广告分组列表", notes = "查看广告分组列表")
    @GetMapping(value = "selectList")
    public PageResponseBean selectList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return adGroupService.selectList(pageNum, pageSize);
    }

    @ApiOperation(value = "搜索广告分组列表", notes = "根据name查看广告分组列表")
    @GetMapping(value = "selectListBySearch")
    public PageResponseBean selectListBySearch(@RequestParam String name, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return adGroupService.selectListBySearch(name, pageNum, pageSize);
    }

    @ApiOperation(value = "修改广告分组", notes = "修改广告分组")
    @PutMapping(value = "updateByPrimaryKeySelective")
    public ResponseEntity<Integer> updateByPrimaryKeySelective(@Valid @RequestBody AdGroupUpdateByPrimaryKeySelective bean, HttpServletRequest request) {
        AdGroup record = new AdGroup();
        record.setId(bean.getId());
        record.setName(bean.getName());
        record.setUpdateBy(super.getSessionUser(request).getTruename());
        return adGroupService.updateByPrimaryKeySelective(record);
    }
}
