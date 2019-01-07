package com.graduation.project.dao.mapper;

import com.graduation.project.dao.entity.MaterialGroup;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MaterialGroupMapper {
    @Update("UPDATE tb_material_group SET del_flag = 1, update_by = #{updateBy}, update_date = now() WHERE id = #{id}")
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("updateBy") String updateBy);

    int insert(MaterialGroup record);

    int insertSelective(MaterialGroup record);

    MaterialGroup selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM tb_material_group WHERE del_flag = 0 ORDER BY create_date DESC")
    List<MaterialGroup> selectList();

    @Select("SELECT * FROM tb_material_group WHERE del_flag = 0 AND name LIKE CONCAT('%',#{name},'%') ORDER BY create_date DESC")
    List<MaterialGroup> selectListBySearch(@Param("name") String name);

    int updateByPrimaryKeySelective(MaterialGroup record);

    int updateByPrimaryKey(MaterialGroup record);
}