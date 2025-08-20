package com.example.laboratory.controller;

import com.example.laboratory.entity.Student;
import com.example.laboratory.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
@Tag(name = "学生管理", description = "学生相关的API接口")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Operation(summary = "注册", description = "创建新的学生记录")
    @PostMapping
    public Map<String, Object> addStudent(@RequestBody Student student) {
        Map<String, Object> result = new HashMap<>();
        int count = studentService.addStudent(student);
        if (count > 0) {
            result.put("success", true);
            result.put("message", "添加学生成功");
        } else {
            result.put("success", false);
            result.put("message", "添加学生失败");
        }
        return result;
    }

    @Operation(summary = "删除学生", description = "根据ID删除学生记录")
    @DeleteMapping("/{id}")
    public Map<String, Object> deleteStudent(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<>();
        int count = studentService.deleteStudent(id);
        if (count > 0) {
            result.put("success", true);
            result.put("message", "删除学生成功");
        } else {
            result.put("success", false);
            result.put("message", "删除学生失败");
        }
        return result;
    }

    @Operation(summary = "更新学生", description = "修改学生记录信息")
    @PutMapping
    public Map<String, Object> updateStudent(@RequestBody Student student) {
        Map<String, Object> result = new HashMap<>();
        int count = studentService.updateStudent(student);
        if (count > 0) {
            result.put("success", true);
            result.put("message", "更新学生成功");
        } else {
            result.put("success", false);
            result.put("message", "更新学生失败");
        }
        return result;
    }

    @Operation(summary = "获取学生", description = "根据ID查询学生记录信息")
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @Operation(summary = "获取所有学生", description = "查询所有学生记录信息")
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Operation(summary = "根据姓名查询学生", description = "根据姓名模糊查询学生记录信息")
    @GetMapping("/name/{name}")
    public List<Student> getStudentsByName(@PathVariable String name) {
        return studentService.getStudentsByName(name);
    }

    @Operation(summary = "根据学号查询学生", description = "根据学号查询学生记录信息")
    @GetMapping("/studentId/{studentId}")
    public Student getStudentByStudentId(@PathVariable String studentId) {
        return studentService.getStudentByStudentId(studentId);
    }

    @Operation(summary = "学生登录", description = "验证学生登录信息")
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody com.example.laboratory.dto.LoginRequest loginRequest) {
        Map<String, Object> result = new HashMap<>();
        String studentId = loginRequest.getStudentId();
        String password = loginRequest.getPassword();
        
        Student student = studentService.login(studentId, password);
        if (student != null) {
            result.put("success", true);
            result.put("message", "登录成功");
            result.put("student", student);
        } else {
            result.put("success", false);
            result.put("message", "学号或密码错误");
        }
        return result;
    }

    @Operation(summary = "修改密码", description = "学生修改密码")
    @PostMapping("/change-password")
    public Map<String, Object> changePassword(@RequestBody com.example.laboratory.dto.ChangePasswordRequest changePasswordRequest) {
        Map<String, Object> result = new HashMap<>();
        Long id = changePasswordRequest.getId();
        String oldPassword = changePasswordRequest.getOldPassword();
        String newPassword = changePasswordRequest.getNewPassword();
        
        int count = studentService.changePassword(id, oldPassword, newPassword);
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