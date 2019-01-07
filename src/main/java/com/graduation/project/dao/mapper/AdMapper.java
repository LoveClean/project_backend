package com.graduation.project.dao.mapper;

import com.graduation.project.dao.entity.Ad;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdMapper {
    @Update("UPDATE tb_ad SET del_flag = 1, update_by = #{updateBy}, update_date = now() WHERE id = #{id}")
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("updateBy") String updateBy);

    int insert(Ad record);

    int insertSelective(Ad record);

    Ad selectByPrimaryKey(Integer id);

    List<Ad> selectList();

    @Select("SELECT * FROM tb_ad WHERE del_flag = 0 AND name LIKE CONCAT('%',#{name},'%') AND groupid = #{groupid} ORDER BY create_date DESC")
    List<Ad> selectListBySearch(@Param("name") String name, @Param("groupid") String groupid);

    @Select("SELECT * FROM tb_ad WHERE del_flag = 0 AND name LIKE CONCAT('%',#{name},'%') ORDER BY create_date DESC")
    List<Ad> selectListByName(@Param("name") String name);

    int updateByPrimaryKeySelective(Ad record);

    int updateByPrimaryKey(Ad record);
}