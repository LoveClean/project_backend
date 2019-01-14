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

    @Select("SELECT * FROM tb_maps WHERE del_flag = 0 AND name = #{name}")
    Maps selectByName(@Param("name") String name);

    @Select("SELECT * FROM tb_maps WHERE del_flag = 0 AND address = #{address}")
    Maps selectByAddress(@Param("address") String address);

    @Select("SELECT * FROM tb_maps WHERE del_flag = 0 AND phone = #{phone}")
    Maps selectByPhone(@Param("phone") String phone);

    @Select("SELECT * FROM tb_maps WHERE del_flag = 0 AND left(area_id,#{number}) LIKE CONCAT('%',#{level},'%') ORDER BY create_date DESC")
    List<Maps> selectList(@Param("level") String level, @Param("number") Integer number);

    @Select("SELECT * FROM tb_maps WHERE del_flag = 0 AND name LIKE CONCAT('%',#{name},'%') AND area_id LIKE CONCAT('%',#{areaId},'%') AND left(area_id,#{number}) LIKE CONCAT('%',#{level},'%') ORDER BY create_date DESC")
    List<Maps>  selectListBySearch(@Param("name") String name, @Param("areaId") String areaId,@Param("level") String level, @Param("number") Integer number);

    int updateByPrimaryKeySelective(Maps record);

    int updateByPrimaryKey(Maps record);

    @Select("SELECT COUNT(*) FROM tb_maps WHERE del_flag = 0 AND left(area_id,#{number}) LIKE CONCAT('%',#{level},'%')")
    int selectTotalElements(@Param("level") String level, @Param("number") Integer number);
}