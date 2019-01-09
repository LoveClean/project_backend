package com.graduation.project.dao.mapper;

import com.graduation.project.dao.entity.AdDelivery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface AdDeliveryMapper {
    @Update("UPDATE tb_ad_delivery SET del_flag = 1, update_by = #{updateBy}, update_date = now() WHERE id = #{id}")
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("updateBy") String updateBy);

    int insert(AdDelivery record);

    int insertSelective(AdDelivery record);

    AdDelivery selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM tb_ad_delivery WHERE del_flag = 0 AND left(area_id,#{number}) LIKE CONCAT('%',#{level},'%') ORDER BY create_date DESC")
    List<AdDelivery> selectList(@Param("level") String level, @Param("number") Integer number);

    @Select("SELECT * FROM tb_ad_delivery WHERE del_flag = 0 AND left(area_id,#{number}) LIKE CONCAT('%',#{level},'%') AND area_id LIKE CONCAT('%',#{areaId},'%') AND address_id LIKE CONCAT('%',#{addressId},'%') AND priority LIKE CONCAT('%',#{priority},'%') ORDER BY create_date DESC")
    List<AdDelivery> selectListBySearch(@Param("level") String level, @Param("number") Integer number, @Param("areaId") String areaId, @Param("addressId") String addressId, @Param("priority") Integer priority);

    int updateByPrimaryKeySelective(AdDelivery record);

    int updateByPrimaryKey(AdDelivery record);
}