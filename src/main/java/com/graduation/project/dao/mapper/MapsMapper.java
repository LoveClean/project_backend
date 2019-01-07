package com.graduation.project.dao.mapper;

import com.graduation.project.dao.entity.Maps;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MapsMapper {
    @Update("UPDATE tb_maps SET del_flag = 1, update_by = #{updateBy}, update_date = now() WHERE id = #{id}")
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("updateBy") String updateBy);

    int insert(Maps record);

    int insertSelective(Maps record);

    Maps selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM tb_maps WHERE name = #{name}")
    Maps selectByName(@Param("name") String name);

    @Select("SELECT * FROM tb_maps WHERE address = #{address}")
    Maps selectByAddress(@Param("address") String address);

    @Select("SELECT * FROM tb_maps WHERE del_flag = 0 ORDER BY create_date DESC")
    List<Maps> selectList();

    @Select("SELECT * FROM tb_maps WHERE del_flag = 0 AND name LIKE CONCAT('%',#{name},'%') AND area_id LIKE CONCAT('%',#{areaId},'%') ORDER BY create_date DESC")
    List<Maps> selectListBySearch(@Param("name") String name, @Param("areaId") String areaId);

    int updateByPrimaryKeySelective(Maps record);

    int updateByPrimaryKey(Maps record);
}