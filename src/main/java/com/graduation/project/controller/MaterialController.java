package com.graduation.project.controller;

import com.graduation.project.controller.request.MaterialInsertSelective;
import com.graduation.project.controller.request.MaterialUpdateByPrimaryKeySelective;
import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.Material;
import com.graduation.project.service.MaterialService;
import com.graduation.project.util.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(description = "素材操作接口", produces = "application/json")
@RestController
@RequestMapping("/Material/")
public class MaterialController extends BaseController {
    @Autowired
    private MaterialService MaterialService;

    @ApiOperation(value = "删除素材", notes = "根据主键删除")
    @DeleteMapping(value = "deleteByPrimaryKey")
    public ResponseEntity<Integer> deleteByPrimaryKey(@RequestParam Integer id, HttpServletRequest request) {
        return MaterialService.deleteByPrimaryKey(id, super.getSessionUser(request).getTruename());
    }

    @ApiOperation(value = "添加素材", notes = "添加素材")
    @PostMapping(value = "insertSelective")
    public ResponseEntity<Integer> insertSelective(@Valid @RequestBody MaterialInsertSelective bean, HttpServletRequest request) {
        Material record = new Material(bean.getName(), bean.getType(), bean.getGroupId(), bean.getPath(), super.getSessionUser(request).getTruename());
        return MaterialService.insertSelective(record);
    }

    @ApiOperation(value = "查看素材", notes = "根据主键查看素材")
    @GetMapping(value = "selectByPrimaryKey")
    public ResponseEntity<Material> selectByPrimaryKey(@RequestParam Integer id) {
        return MaterialService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "查看素材列表", notes = "查看素材列表")
    @GetMapping(value = "selectList")
    public PageResponseBean selectList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return MaterialService.selectList(pageNum, pageSize);
    }

    @ApiOperation(value = "搜索素材列表", notes = "根据type、name和groupId查看素材列表")
    @GetMapping(value = "selectListBySearch")
    public PageResponseBean selectListBySearch(@RequestParam String type, @RequestParam String name, @RequestParam String groupId, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return MaterialService.selectListBySearch(type, name, groupId, pageNum, pageSize);
    }

    @ApiOperation(value = "修改素材", notes = "修改素材")
    @PutMapping(value = "updateByPrimaryKeySelective")
    public ResponseEntity<Integer> updateByPrimaryKeySelective(@Valid @RequestBody MaterialUpdateByPrimaryKeySelective bean, HttpServletRequest request) {
        Material record = new Material();
        record.setId(bean.getId());
        record.setName(bean.getName());
        record.setType(bean.getType());
        record.setGroupId(bean.getGroupId());
        record.setPath(bean.getPath());
        record.setUpdateBy(super.getSessionUser(request).getTruename());
        return MaterialService.updateByPrimaryKeySelective(record);
    }
}