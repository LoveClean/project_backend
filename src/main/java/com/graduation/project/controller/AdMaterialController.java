package com.graduation.project.controller;

import com.google.common.collect.Lists;
import com.graduation.project.controller.request.AdMaterialInsertSelective;
import com.graduation.project.controller.request.AdMaterialUpdateByPrimaryKeySelective;
import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.AdMaterial;
import com.graduation.project.service.AdMaterialService;
import com.graduation.project.util.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Api(description = "广告素材操作接口", produces = "application/json")
@RestController
@RequestMapping("/AdMaterial/")
public class AdMaterialController extends BaseController {
    @Autowired
    private AdMaterialService adMaterialService;

    @ApiOperation(value = "删除广告素材", notes = "根据主键删除")
    @DeleteMapping(value = "deleteByPrimaryKey")
    public ResponseEntity<Integer> deleteByPrimaryKey(@RequestParam Integer id, HttpServletRequest request) {
        return adMaterialService.deleteByPrimaryKey(id, super.getSessionUser(request).getTruename());
    }

    @ApiOperation(value = "添加广告素材", notes = "添加广告素材")
    @PostMapping(value = "insertSelective")
    public ResponseEntity<Integer> insertSelective(@Valid @RequestBody AdMaterialInsertSelective bean, HttpServletRequest request) {
        AdMaterial record = new AdMaterial(bean.getAdid(), bean.getMaterialid(), bean.getOrderindex(), bean.getLoadstep(), bean.getDisplaytime(), bean.getMusicpath(), super.getSessionUser(request).getTruename());
        return adMaterialService.insertSelective(record);
    }

    @ApiOperation(value = "批量添加广告素材", notes = "批量添加广告素材")
    @PostMapping(value = "insertSelectiveList")
    public ResponseEntity<Integer> insertSelectiveList(@Valid @RequestBody List<AdMaterialInsertSelective> beans, HttpServletRequest request) {
        List<AdMaterial> records = Lists.newArrayList();
        for (AdMaterialInsertSelective bean : beans) {
            AdMaterial record = new AdMaterial(bean.getAdid(), bean.getMaterialid(), bean.getOrderindex(), bean.getLoadstep(), bean.getDisplaytime(), bean.getMusicpath(), super.getSessionUser(request).getTruename());
            records.add(record);
        }
        return adMaterialService.insertSelectiveList(records);
    }

    @ApiOperation(value = "查看广告素材", notes = "根据主键查看广告素材")
    @GetMapping(value = "selectByPrimaryKey")
    public ResponseEntity<AdMaterial> selectByPrimaryKey(@RequestParam Integer id) {
        return adMaterialService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "查看广告素材列表", notes = "查看广告素材列表")
    @GetMapping(value = "selectList")
    public PageResponseBean selectList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return adMaterialService.selectList(pageNum, pageSize);
    }

    @ApiOperation(value = "修改广告素材", notes = "修改广告素材")
    @PutMapping(value = "updateByPrimaryKeySelective")
    public ResponseEntity<Integer> updateByPrimaryKeySelective(@Valid @RequestBody AdMaterialUpdateByPrimaryKeySelective bean, HttpServletRequest request) {
        AdMaterial record = new AdMaterial();
        record.setId(bean.getId());
        record.setAdid(bean.getAdid());
        record.setMaterialid(bean.getMaterialid());
        record.setOrderindex(bean.getOrderindex());
        record.setLoadstep(bean.getLoadstep());
        record.setDisplaytime(bean.getDisplaytime());
        record.setMusicpath(bean.getMusicpath());
        record.setUpdateBy(super.getSessionUser(request).getTruename());
        return adMaterialService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation(value = "批量修改广告素材", notes = "批量修改广告素材")
    @PutMapping(value = "updateByPrimaryKeySelectiveList")
    public ResponseEntity<Integer> updateByPrimaryKeySelectiveList(@Valid @RequestBody List<AdMaterialUpdateByPrimaryKeySelective> beans, HttpServletRequest request) {
        List<AdMaterial> records = Lists.newArrayList();
        for (AdMaterialUpdateByPrimaryKeySelective bean : beans) {
            AdMaterial record = new AdMaterial();
            record.setId(bean.getId());
            record.setAdid(bean.getAdid());
            record.setMaterialid(bean.getMaterialid());
            record.setOrderindex(bean.getOrderindex());
            record.setLoadstep(bean.getLoadstep());
            record.setDisplaytime(bean.getDisplaytime());
            record.setMusicpath(bean.getMusicpath());
            record.setUpdateBy(super.getSessionUser(request).getTruename());
            records.add(record);
        }
        return adMaterialService.updateByPrimaryKeySelectiveList(records);
    }
}
