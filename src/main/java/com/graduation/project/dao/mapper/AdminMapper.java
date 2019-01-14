package com.graduation.project.dao.mapper;

import com.graduation.project.dao.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface AdminMapper {
    @Update("UPDATE tb_admin SET del_flag = 1, update_by = #{updateBy}, update_date = now() WHERE id = #{id}")
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("updateBy") String updateBy);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM tb_admin WHERE phone = #{phone}")
    Admin selectByPhone(@Param("phone") String phone);

    @Select("SELECT * FROM tb_admin WHERE del_flag = 0 AND left(level,#{number}) = #{level} ORDER BY create_date DESC")
    List<Admin> selectList(@Param("level") String level, @Param("number") Integer number);

    @Select("SELECT * FROM tb_admin WHERE del_flag = 0 AND phone LIKE CONCAT('%',#{phone},'%') AND level LIKE CONCAT('%',#{level},'%') AND left(level,#{number}) = #{level0} ORDER BY create_date DESC")
    List<Admin> selectListBySearch(@Param("phone") String phone, @Param("level") String level, @Param("level0") String level0, @Param("number") Integer number);

    int updateByPrimaryKeySelective(Admin record);

    @Update("UPDATE tb_admin SET password = #{newPassword}, update_by = #{updateBy}, update_date = now() WHERE id = #{id} AND password = #{oldPassword} AND del_flag = 0")
    int updatePasswordById(@Param("id") Integer id, @Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword, @Param("updateBy") String updateBy);

    @Update("UPDATE tb_admin SET status = #{status}, update_by = #{updateBy}, update_date = now() WHERE id = #{id} AND del_flag = 0")
    int updateStatusById(@Param("id") Integer id, @Param("status") Integer status, @Param("updateBy") String updateBy);

    int updateByPrimaryKey(Admin record);

    @Select("SELECT * FROM tb_admin WHERE phone = #{phone} AND password = #{password}")
    Admin login(@Param("phone") String phone, @Param("password") String password);

    @Select("SELECT COUNT(*) FROM tb_admin WHERE del_flag = 0 AND left(level,#{number}) = #{level}")
    int selectTotalElements(@Param("level") String level, @Param("number") Integer number);
}