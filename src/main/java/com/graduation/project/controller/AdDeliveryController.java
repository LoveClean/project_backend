package com.graduation.project.controller;

import com.graduation.project.controller.request.AdDeliveryInsertSelective;
import com.graduation.project.controller.request.AdDeliveryUpdateByPrimaryKeySelective;
import com.graduation.project.controller.response.PageResponseBean;
import com.graduation.project.dao.entity.AdDelivery;
import com.graduation.project.service.AdDeliveryService;
import com.graduation.project.util.DateUtil;
import com.graduation.project.util.ResponseEntity;
import com.graduation.project.util.ResponseEntityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

@Api(description = "广告投放操作接口", produces = "application/json")
@RestController
@RequestMapping("/AdDelivery/")
public class AdDeliveryController extends BaseController {
    @Autowired
    private AdDeliveryService adDeliveryService;

    @ApiOperation(value = "删除广告投放", notes = "根据主键删除")
    @DeleteMapping(value = "deleteByPrimaryKey")
    public ResponseEntity<Integer> deleteByPrimaryKey(@RequestParam Integer id, HttpServletRequest request) {
        return adDeliveryService.deleteByPrimaryKey(id, super.getSessionUser(request).getTruename());
    }

    @ApiOperation(value = "添加广告投放", notes = "添加广告投放")
    @PostMapping(value = "insertSelective")
    public ResponseEntity<Integer> insertSelective(@Valid @RequestBody AdDeliveryInsertSelective bean, HttpServletRequest request) {
        // 校验身份等级，防止越权
        String level = super.getSessionUser(request).getLevel();
        int levelLength = level.length();
        if (!bean.getAreaId().substring(0, levelLength).equals(level)) {
            return ResponseEntityUtil.fail("身份越权");
        }

        Date beginTime = DateUtil.stringToDate(bean.getBeginTime(), DateUtil.DEFAULT_PATTERN);
        Date endTime = DateUtil.stringToDate(bean.getEndTime(), DateUtil.DEFAULT_PATTERN);
        AdDelivery record = new AdDelivery(bean.getAdId(), bean.getPriority(), bean.getAreaId(), bean.getAddressId(), beginTime, endTime, super.getSessionUser(request).getTruename());
        return adDeliveryService.insertSelective(record);
    }

    @ApiOperation(value = "查看广告投放", notes = "根据主键查看广告投放")
    @GetMapping(value = "selectByPrimaryKey")
    public ResponseEntity<AdDelivery> selectByPrimaryKey(@RequestParam Integer id) {
        return adDeliveryService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "查看广告投放列表", notes = "查看广告投放列表")
    @GetMapping(value = "selectList")
    public PageResponseBean selectList(@RequestParam Integer pageNum, @RequestParam Integer pageSize, HttpServletRequest request) {
        return adDeliveryService.selectList(pageNum, pageSize, super.getSessionUser(request).getLevel());
    }

    @ApiOperation(value = "搜索广告投放列表", notes = "搜索广告投放列表")
    @GetMapping(value = "selectListBySearch")
    public PageResponseBean selectListBySearch(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String areaId, @RequestParam String addressId, HttpServletRequest request) {
        return adDeliveryService.selectListBySearch(pageNum, pageSize, super.getSessionUser(request).getLevel(), areaId, addressId);
    }

    @ApiOperation(value = "修改广告投放", notes = "修改广告投放")
    @PutMapping(value = "updateByPrimaryKeySelective")
    public ResponseEntity<Integer> updateByPrimaryKeySelective(@Valid @RequestBody AdDeliveryUpdateByPrimaryKeySelective bean, HttpServletRequest request) {
        // 校验身份等级，防止越权
        String level = super.getSessionUser(request).getLevel();
        int levelLength = level.length();
        if (!bean.getAreaId().substring(0, levelLength).equals(level)) {
            return ResponseEntityUtil.fail("身份越权");
        }

        AdDelivery record = new AdDelivery();
        record.setId(bean.getId());
        record.setAdId(bean.getAdId());
        record.setPriority(bean.getPriority());
        record.setAreaId(bean.getAreaId());
        record.setAddressId(bean.getAddressId());
        record.setBeginTime(DateUtil.stringToDate(bean.getBeginTime(), DateUtil.DEFAULT_PATTERN));
        record.setEndTime(DateUtil.stringToDate(bean.getEndTime(), DateUtil.DEFAULT_PATTERN));
        record.setUpdateBy(super.getSessionUser(request).getTruename());
        return adDeliveryService.updateByPrimaryKeySelective(record);
    }
}
