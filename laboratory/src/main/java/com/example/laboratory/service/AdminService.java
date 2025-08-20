package com.example.laboratory.service;

import com.example.laboratory.entity.Admin;

import java.util.List;

public interface AdminService {
    // 添加管理员
    int addAdmin(Admin admin);

    // 删除管理员
    int deleteAdmin(Long id);

    // 更新管理员
    int updateAdmin(Admin admin);

    // 根据ID查询管理员
    Admin getAdminById(Long id);

    // 查询所有管理员
    List<Admin> getAllAdmins();

    // 根据用户名查询管理员
    Admin getAdminByUsername(String username);

    // 登录验证
    Admin login(String username, String password);

    // 修改密码
    int changePassword(Long id, String oldPassword, String newPassword);
}