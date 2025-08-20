package com.example.laboratory.service.impl;

import com.example.laboratory.entity.Admin;
import com.example.laboratory.mapper.AdminMapper;
import com.example.laboratory.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int addAdmin(Admin admin) {
        // 不加密，直接存储明文密码
        return adminMapper.insert(admin);
    }

    @Override
    public int deleteAdmin(Long id) {
        return adminMapper.deleteById(id);
    }

    @Override
    public int updateAdmin(Admin admin) {
        // 不加密，直接存储明文密码
        return adminMapper.update(admin);
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminMapper.selectById(id);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminMapper.selectAll();
    }

    @Override
    public Admin getAdminByUsername(String username) {
        return adminMapper.selectByUsername(username);
    }

    @Override
    public Admin login(String username, String password) {
        // 根据用户名查询管理员
        Admin admin = adminMapper.selectByUsername(username);
        if (admin != null) {
            // 直接比较明文密码
            if (password.equals(admin.getPassword())) {
                return admin;
            }
        }
        return null;
    }

    @Override
    public int changePassword(Long id, String oldPassword, String newPassword) {
        Admin admin = adminMapper.selectById(id);
        if (admin == null || !admin.getPassword().equals(oldPassword)) {
            return 0;
        }
        admin.setPassword(newPassword);
        return adminMapper.update(admin);
    }
}