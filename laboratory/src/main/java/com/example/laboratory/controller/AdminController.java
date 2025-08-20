package com.example.laboratory.controller;

import com.example.laboratory.entity.Admin;
import com.example.laboratory.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@Tag(name = "管理员管理", description = "管理员相关的API接口")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Operation(summary = "管理员登录", description = "验证管理员登录信息")
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody com.example.laboratory.dto.AdminLoginRequest loginRequest) {
        Map<String, Object> result = new HashMap<>();
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        
        Admin admin = adminService.login(username, password);
        if (admin != null) {
            result.put("success", true);
            result.put("message", "登录成功");
            result.put("admin", admin);
        } else {
            result.put("success", false);
            result.put("message", "用户名或密码错误");
        }
        return result;
    }

    @Operation(summary = "添加管理员", description = "创建新管理员")
    @PostMapping
    public Map<String, Object> addAdmin(@RequestBody Admin admin) {
        Map<String, Object> result = new HashMap<>();
        int count = adminService.addAdmin(admin);
        if (count > 0) {
            result.put("success", true);
            result.put("message", "添加管理员成功");
        } else {
            result.put("success", false);
            result.put("message", "添加管理员失败");
        }
        return result;
    }

    @Operation(summary = "删除管理员", description = "根据ID删除管理员")
    @DeleteMapping("/{id}")
    public Map<String, Object> deleteAdmin(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<>();
        int count = adminService.deleteAdmin(id);
        if (count > 0) {
            result.put("success", true);
            result.put("message", "删除管理员成功");
        } else {
            result.put("success", false);
            result.put("message", "删除管理员失败");
        }
        return result;
    }

    @Operation(summary = "更新管理员", description = "修改管理员信息")
    @PutMapping
    public Map<String, Object> updateAdmin(@RequestBody Admin admin) {
        Map<String, Object> result = new HashMap<>();
        int count = adminService.updateAdmin(admin);
        if (count > 0) {
            result.put("success", true);
            result.put("message", "更新管理员成功");
        } else {
            result.put("success", false);
            result.put("message", "更新管理员失败");
        }
        return result;
    }

    @Operation(summary = "获取管理员", description = "根据ID查询管理员信息")
    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    @Operation(summary = "获取所有管理员", description = "查询所有管理员信息")
    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @Operation(summary = "根据用户名查询管理员", description = "根据用户名查询管理员信息")
    @GetMapping("/username/{username}")
    public Admin getAdminByUsername(@PathVariable String username) {
        return adminService.getAdminByUsername(username);
    }

    @Operation(summary = "修改密码", description = "管理员修改密码")
    @PostMapping("/change-password")
    public Map<String, Object> changePassword(@RequestBody com.example.laboratory.dto.ChangePasswordRequest changePasswordRequest) {
        Map<String, Object> result = new HashMap<>();
        Long id = changePasswordRequest.getId();
        String oldPassword = changePasswordRequest.getOldPassword();
        String newPassword = changePasswordRequest.getNewPassword();
        
        int count = adminService.changePassword(id, oldPassword, newPassword);
        if (count > 0) {
            result.put("success", true);
            result.put("message", "密码修改成功");
        } else {
            result.put("success", false);
            result.put("message", "原密码错误或用户不存在");
        }
        return result;
    }
}