package com.graduation.project.dao.mapper;

import com.graduation.project.dao.entity.Material;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MaterialMapper {
    @Update("UPDATE tb_material SET del_flag = 1, update_by = #{updateBy}, update_date = now() WHERE id = #{id}")
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("updateBy") String updateBy);

    int insert(Material record);

    int insertSelective(Material record);

    Material selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM tb_material WHERE del_flag = 0 ORDER BY create_date DESC")
    List<Material> selectList();

    @Select("SELECT * FROM tb_material WHERE del_flag = 0 AND name LIKE CONCAT('%',#{name},'%') AND group_id = #{groupId} ORDER BY create_date DESC")
    List<Material> selectListBySearch(@Param("name") String name, @Param("groupId") String groupId);

    @Select("SELECT * FROM tb_material WHERE del_flag = 0 AND name LIKE CONCAT('%',#{name},'%') ORDER BY create_date DESC")
    List<Material> selectListByName(@Param("name") String name);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);
}