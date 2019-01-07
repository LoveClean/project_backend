package com.graduation.project.dao.mapper;

import com.graduation.project.dao.entity.AdDelivery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdDeliveryMapper {
    @Update("UPDATE tb_ad_delivery SET del_flag = 1, update_by = #{updateBy}, update_date = now() WHERE id = #{id}")
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("updateBy") String updateBy);

    int insert(AdDelivery record);

    int insertSelective(AdDelivery record);

    AdDelivery selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM tb_ad_delivery WHERE del_flag = 0 ORDER BY create_date DESC")
    List<AdDelivery> selectList();

    int updateByPrimaryKeySelective(AdDelivery record);

    int updateByPrimaryKey(AdDelivery record);
}