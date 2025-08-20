package com.example.laboratory.mapper;

import com.example.laboratory.entity.Admin;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

@Mapper
public interface AdminMapper {
    // 添加管理员
    @Insert("INSERT INTO admin(username, password, phone) VALUES(#{username}, #{password}, #{phone})")
    int insert(Admin admin);

    // 删除管理员
    @Delete("DELETE FROM admin WHERE id = #{id}")
    int deleteById(Long id);

    // 动态更新管理员（只更新非空字段）
    @UpdateProvider(type = AdminSqlProvider.class, method = "updateAdmin")
    int update(Admin admin);

    // 根据ID查询管理员
    @Select("SELECT * FROM admin WHERE id = #{id}")
    Admin selectById(Long id);

    // 查询所有管理员
    @Select("SELECT * FROM admin")
    List<Admin> selectAll();

    // 根据用户名查询管理员
    @Select("SELECT * FROM admin WHERE username = #{username}")
    Admin selectByUsername(String username);

    // SQL提供者类，用于构建动态SQL
    class AdminSqlProvider {
        public String updateAdmin(Admin admin) {
            return new SQL() {{
                UPDATE("admin");
                if (admin.getUsername() != null && !admin.getUsername().trim().isEmpty()) {
                    SET("username = #{username}");
                }
                if (admin.getPassword() != null && !admin.getPassword().trim().isEmpty()) {
                    SET("password = #{password}");
                }
                if (admin.getPhone() != null && !admin.getPhone().trim().isEmpty()) {
                    SET("phone = #{phone}");
                }
                WHERE("id = #{id}");
            }}.toString();
        }
    }
}